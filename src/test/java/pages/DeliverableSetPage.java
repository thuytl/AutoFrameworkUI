package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.util.List;

public class DeliverableSetPage extends BasePage {

    // URL and title for deliverable set page
    private String urlDeliverableSet = "http://example.com/deliverable-set";
    private String titleDeliverableSet = "Deliverable Set";

    // Locators for right sidebar
    private By rightSidebar = By.cssSelector(".right-sidebar");
    private By commentsActivitiesHeader = By.cssSelector(".right-sidebar .header");
    private By sidebarCollapseButton = By.cssSelector(".sidebar-collapse-btn");
    private By sidebarExpandButton = By.cssSelector(".sidebar-expand-btn");
    
    // Locators for TFL file list
    private By tflFileList = By.cssSelector(".tfl-file-list");
    
    // Locators for tabs
    private By tabContainer = By.cssSelector(".tab-container");
    private By activeTab = By.cssSelector(".tab.active");
    private By tableOfContentsTab = By.cssSelector(".tab[data-name='Table of contents']");
    
    // Locators for main view area
    private By mainViewArea = By.cssSelector(".main-view-area");
    private By fileContent = By.cssSelector(".file-content");

    public DeliverableSetPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = urlDeliverableSet;
        this.PAGE_TITLE = titleDeliverableSet;
    }

    /**
     * Verify that the right sidebar is visible
     */
    public void verifyRightSidebarVisible() {
        WebElement sidebar = findWebElement(rightSidebar);
        Assert.assertTrue("Right sidebar should be visible", sidebar.isDisplayed());
    }

    /**
     * Verify that the Comments & Activities area is displayed
     */
    public void verifyCommentsActivitiesDisplayed() {
        WebElement header = findWebElement(commentsActivitiesHeader);
        Assert.assertTrue("Comments & Activities header should be displayed", header.isDisplayed());
        Assert.assertTrue("Comments & Activities text should be present", 
            header.getText().contains("Comments & Activities") || 
            header.getText().contains("Comments") || 
            header.getText().contains("Activities"));
    }

    /**
     * Check if right sidebar is expanded
     */
    public boolean isRightSidebarExpanded() {
        WebElement sidebar = findWebElement(rightSidebar);
        String classAttr = sidebar.getAttribute("class");
        return !classAttr.contains("collapsed");
    }

    /**
     * Check if right sidebar is collapsed
     */
    public boolean isRightSidebarCollapsed() {
        WebElement sidebar = findWebElement(rightSidebar);
        String classAttr = sidebar.getAttribute("class");
        return classAttr.contains("collapsed");
    }

    /**
     * Click to collapse the right sidebar
     */
    public void collapseRightSidebar() {
        WebElement collapseBtn = findWebElement(sidebarCollapseButton);
        clickElement(collapseBtn);
    }

    /**
     * Click to expand the right sidebar
     */
    public void expandRightSidebar() {
        WebElement expandBtn = findWebElement(sidebarExpandButton);
        clickElement(expandBtn);
    }

    /**
     * Verify that the right sidebar is collapsed
     */
    public void verifyRightSidebarCollapsed() {
        Assert.assertTrue("Right sidebar should be collapsed", isRightSidebarCollapsed());
    }

    /**
     * Verify that the right sidebar is expanded
     */
    public void verifyRightSidebarExpanded() {
        Assert.assertTrue("Right sidebar should be expanded", isRightSidebarExpanded());
    }

    /**
     * Select a TFL file from the list by name
     */
    public void selectTFLFile(String fileName) {
        By fileLocator = By.cssSelector(".tfl-file-list .file-item[data-name='" + fileName + "']");
        WebElement fileItem = findWebElement(fileLocator);
        clickElement(fileItem);
    }

    /**
     * Verify that file content is displayed in main view
     */
    public void verifyFileContentDisplayed() {
        WebElement content = findWebElement(fileContent);
        Assert.assertTrue("File content should be displayed", content.isDisplayed());
    }

    /**
     * Verify that a tab with specific name exists
     */
    public void verifyTabExists(String tabName) {
        By tabLocator = By.cssSelector(".tab[data-name='" + tabName + "']");
        WebElement tab = findWebElement(tabLocator);
        Assert.assertTrue("Tab '" + tabName + "' should exist", tab.isDisplayed());
    }

    /**
     * Verify that a tab is active
     */
    public void verifyTabIsActive(String tabName) {
        By tabLocator = By.cssSelector(".tab[data-name='" + tabName + "'].active");
        WebElement tab = findWebElement(tabLocator);
        Assert.assertTrue("Tab '" + tabName + "' should be active", tab.isDisplayed());
    }

    /**
     * Get the number of tabs
     */
    public int getTabCount() {
        List<WebElement> tabs = webDriver.findElements(By.cssSelector(".tab"));
        return tabs.size();
    }

    /**
     * Click the close icon on a specific tab
     */
    public void closeTab(String tabName) {
        By closeIconLocator = By.cssSelector(".tab[data-name='" + tabName + "'] .close-icon");
        WebElement closeIcon = findWebElement(closeIconLocator);
        clickElement(closeIcon);
    }

    /**
     * Verify that a tab does not exist
     */
    public void verifyTabNotExists(String tabName) {
        By tabLocator = By.cssSelector(".tab[data-name='" + tabName + "']");
        List<WebElement> tabs = webDriver.findElements(tabLocator);
        Assert.assertTrue("Tab '" + tabName + "' should not exist", tabs.isEmpty());
    }

    /**
     * Verify that Table of Contents tab does not have close icon
     */
    public void verifyTableOfContentsTabNoCloseIcon() {
        By closeIconLocator = By.cssSelector(".tab[data-name='Table of contents'] .close-icon");
        List<WebElement> closeIcons = webDriver.findElements(closeIconLocator);
        Assert.assertTrue("Table of contents tab should not have a close icon", closeIcons.isEmpty());
    }

    /**
     * Verify that a specific tab is still visible
     */
    public void verifyTabIsVisible(String tabName) {
        By tabLocator = By.cssSelector(".tab[data-name='" + tabName + "']");
        WebElement tab = findWebElement(tabLocator);
        Assert.assertTrue("Tab '" + tabName + "' should be visible", tab.isDisplayed());
    }

    /**
     * Click on a tab to focus it
     */
    public void clickTab(String tabName) {
        By tabLocator = By.cssSelector(".tab[data-name='" + tabName + "']");
        WebElement tab = findWebElement(tabLocator);
        clickElement(tab);
    }

    /**
     * Verify that main view area is expanded (when sidebar is collapsed)
     */
    public void verifyMainViewExpanded() {
        WebElement mainView = findWebElement(mainViewArea);
        String classAttr = mainView.getAttribute("class");
        Assert.assertTrue("Main view area should be expanded", 
            classAttr.contains("expanded") || !classAttr.contains("narrow"));
    }
}
