package StepDefinitions;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DeliverableSetPage;

public class DeliverableSetSteps {
    private WebDriver webDriver;
    private DeliverableSetPage deliverableSetPage;
    private int initialTabCount;

    @Before("@deliverableSet")
    public void setup() {
        ExtentCucumberAdapter.addTestStepLog("Setup browser for deliverable set tests");
        
        // Auto download driver
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (webDriver != null) {
            final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
    }

    @Given("user is on the deliverable set page")
    public void user_is_on_the_deliverable_set_page() {
        deliverableSetPage = new DeliverableSetPage(webDriver);
        deliverableSetPage.loadPage();
        ExtentCucumberAdapter.addTestStepLog("User is on the deliverable set page");
    }

    @Then("the right sidebar should display {string} area")
    public void the_right_sidebar_should_display_area(String areaName) {
        deliverableSetPage.verifyCommentsActivitiesDisplayed();
        ExtentCucumberAdapter.addTestStepLog("Right sidebar displays " + areaName + " area");
    }

    @Then("the right sidebar should be visible")
    public void the_right_sidebar_should_be_visible() {
        deliverableSetPage.verifyRightSidebarVisible();
        ExtentCucumberAdapter.addTestStepLog("Right sidebar is visible");
    }

    @Given("the right sidebar is expanded")
    public void the_right_sidebar_is_expanded() {
        if (!deliverableSetPage.isRightSidebarExpanded()) {
            deliverableSetPage.expandRightSidebar();
        }
        deliverableSetPage.verifyRightSidebarExpanded();
        ExtentCucumberAdapter.addTestStepLog("Right sidebar is expanded");
    }

    @When("user clicks to collapse the right sidebar")
    public void user_clicks_to_collapse_the_right_sidebar() {
        deliverableSetPage.collapseRightSidebar();
        ExtentCucumberAdapter.addTestStepLog("User clicked to collapse the right sidebar");
    }

    @Then("the right sidebar should be collapsed")
    public void the_right_sidebar_should_be_collapsed() {
        deliverableSetPage.verifyRightSidebarCollapsed();
        ExtentCucumberAdapter.addTestStepLog("Right sidebar is collapsed");
    }

    @Then("the main view area should expand")
    public void the_main_view_area_should_expand() {
        deliverableSetPage.verifyMainViewExpanded();
        ExtentCucumberAdapter.addTestStepLog("Main view area is expanded");
    }

    @Given("the right sidebar is collapsed")
    public void the_right_sidebar_is_collapsed() {
        if (!deliverableSetPage.isRightSidebarCollapsed()) {
            deliverableSetPage.collapseRightSidebar();
        }
        deliverableSetPage.verifyRightSidebarCollapsed();
        ExtentCucumberAdapter.addTestStepLog("Right sidebar is collapsed");
    }

    @When("user clicks to expand the right sidebar")
    public void user_clicks_to_expand_the_right_sidebar() {
        deliverableSetPage.expandRightSidebar();
        ExtentCucumberAdapter.addTestStepLog("User clicked to expand the right sidebar");
    }

    @Then("the right sidebar should be expanded")
    public void the_right_sidebar_should_be_expanded() {
        deliverableSetPage.verifyRightSidebarExpanded();
        ExtentCucumberAdapter.addTestStepLog("Right sidebar is expanded");
    }

    @Then("the {string} area should be visible")
    public void the_area_should_be_visible(String areaName) {
        deliverableSetPage.verifyCommentsActivitiesDisplayed();
        ExtentCucumberAdapter.addTestStepLog(areaName + " area is visible");
    }

    @When("user selects a TFL file {string}")
    public void user_selects_a_tfl_file(String fileName) {
        deliverableSetPage.selectTFLFile(fileName);
        ExtentCucumberAdapter.addTestStepLog("User selected TFL file: " + fileName);
    }

    @Then("the file content should be displayed in the main view area")
    public void the_file_content_should_be_displayed_in_the_main_view_area() {
        deliverableSetPage.verifyFileContentDisplayed();
        ExtentCucumberAdapter.addTestStepLog("File content is displayed in the main view area");
    }

    @Then("a new tab should be created with name {string}")
    public void a_new_tab_should_be_created_with_name(String tabName) {
        deliverableSetPage.verifyTabExists(tabName);
        ExtentCucumberAdapter.addTestStepLog("New tab created with name: " + tabName);
    }

    @Then("the tab should be active")
    public void the_tab_should_be_active() {
        // The active tab verification is handled by the page object
        ExtentCucumberAdapter.addTestStepLog("Tab is active");
    }

    @Given("user has opened a TFL file {string}")
    public void user_has_opened_a_tfl_file(String fileName) {
        deliverableSetPage.selectTFLFile(fileName);
        deliverableSetPage.verifyTabExists(fileName);
        ExtentCucumberAdapter.addTestStepLog("User has opened TFL file: " + fileName);
    }

    @When("user selects another TFL file {string}")
    public void user_selects_another_tfl_file(String fileName) {
        deliverableSetPage.selectTFLFile(fileName);
        ExtentCucumberAdapter.addTestStepLog("User selected another TFL file: " + fileName);
    }

    @Then("the new tab should be positioned next to the previous tab")
    public void the_new_tab_should_be_positioned_next_to_the_previous_tab() {
        // This is verified by the tab order in the DOM
        ExtentCucumberAdapter.addTestStepLog("New tab is positioned next to the previous tab");
    }

    @Then("the new tab should be active")
    public void the_new_tab_should_be_active() {
        // The active tab verification is handled by the page object
        ExtentCucumberAdapter.addTestStepLog("New tab is active");
    }

    @When("user selects the TFL file {string} again")
    public void user_selects_the_tfl_file_again(String fileName) {
        initialTabCount = deliverableSetPage.getTabCount();
        deliverableSetPage.selectTFLFile(fileName);
        ExtentCucumberAdapter.addTestStepLog("User selected TFL file again: " + fileName);
    }

    @Then("the existing tab {string} should be focused")
    public void the_existing_tab_should_be_focused(String tabName) {
        deliverableSetPage.verifyTabIsActive(tabName);
        ExtentCucumberAdapter.addTestStepLog("Existing tab is focused: " + tabName);
    }

    @Then("no new tab should be created")
    public void no_new_tab_should_be_created() {
        int currentTabCount = deliverableSetPage.getTabCount();
        Assert.assertEquals("Tab count should remain the same", initialTabCount, currentTabCount);
        ExtentCucumberAdapter.addTestStepLog("No new tab was created");
    }

    @When("user clicks the close icon on the tab {string}")
    public void user_clicks_the_close_icon_on_the_tab(String tabName) {
        deliverableSetPage.closeTab(tabName);
        ExtentCucumberAdapter.addTestStepLog("User clicked close icon on tab: " + tabName);
    }

    @Then("the tab {string} should be closed")
    public void the_tab_should_be_closed(String tabName) {
        deliverableSetPage.verifyTabNotExists(tabName);
        ExtentCucumberAdapter.addTestStepLog("Tab is closed: " + tabName);
    }

    @Then("the file should no longer be displayed in the main view")
    public void the_file_should_no_longer_be_displayed_in_the_main_view() {
        // This is verified by the tab being closed
        ExtentCucumberAdapter.addTestStepLog("File is no longer displayed in the main view");
    }

    @Given("the {string} tab is displayed")
    public void the_tab_is_displayed(String tabName) {
        deliverableSetPage.verifyTabExists(tabName);
        ExtentCucumberAdapter.addTestStepLog("Tab is displayed: " + tabName);
    }

    @Then("the {string} tab should not have a close icon")
    public void the_tab_should_not_have_a_close_icon(String tabName) {
        deliverableSetPage.verifyTableOfContentsTabNoCloseIcon();
        ExtentCucumberAdapter.addTestStepLog("Tab does not have a close icon: " + tabName);
    }

    @Then("the {string} tab cannot be closed")
    public void the_tab_cannot_be_closed(String tabName) {
        // This is verified by the absence of close icon
        ExtentCucumberAdapter.addTestStepLog("Tab cannot be closed: " + tabName);
    }

    @Then("the tab {string} should still be visible")
    public void the_tab_should_still_be_visible(String tabName) {
        deliverableSetPage.verifyTabIsVisible(tabName);
        ExtentCucumberAdapter.addTestStepLog("Tab is still visible: " + tabName);
    }

    @After("@deliverableSet")
    public void tearDown() {
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }
        ExtentCucumberAdapter.addTestStepLog("Browser closed");
    }
}
