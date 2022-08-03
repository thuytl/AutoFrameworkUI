package StepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.model.Report;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

public class addProductSteps {
    private WebDriver webDriver;
    private LoginPage loginPage;
    private HomePage homePage;
    Scenario scenario;
    private ExtentTest test;
    private ExtentReports extent;
    private String baseUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @Before
    public void setup() {

        extent =  new ExtentReports();

        ExtentCucumberAdapter.addTestStepLog("Setup browser");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }
    @AfterStep
    public void addScreenshot(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "image");
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
        loginPage = new LoginPage(webDriver);
        loginPage.loadPage();

        ExtentCucumberAdapter.addTestStepLog("On login page");
    }
    @When("user enters email and password")
    public void user_enters_email_and_password() {
        loginPage.enterEmail("thanhthanh@gmail.com");
        loginPage.enterPassword("thanhthanh");
        ExtentCucumberAdapter.addTestStepLog("Entered email and password");
    }
    @And("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickLogin();
        ExtentCucumberAdapter.addTestStepLog("clicked on login button");
    }
    @Then("user is navigated to the account page")
    public void user_is_navigated_to_the_account_page() {
        loginPage.LogoutButtonIsDisplayed();
        ExtentCucumberAdapter.addTestStepLog("Navigated to the account page");
    }
    @Given("user is on home page")
    public void user_is_on_home_page() {
        homePage = new HomePage(webDriver);
        homePage.loadPage();
        ExtentCucumberAdapter.addTestStepLog("On home page");
    }
    @When("^user hovers on (.*) and click Add to cart$")
    public void user_hovers_on_item_and_click_add_to_cart(String item) throws InterruptedException {
        homePage.hoverOnItem(item);
        ExtentCucumberAdapter.addTestStepLog("Hovered on "+item+" and clicked Add to cart button");
    }

    @Then("the item is added to cart")
    public void the_item_is_added_to_cart() throws InterruptedException {
        homePage.AddedModalIsDisplayed();
        ExtentCucumberAdapter.addTestStepLog("On login page");
        Thread.sleep(3000);

    }
    @After
    public void end() {
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }
    }
}
