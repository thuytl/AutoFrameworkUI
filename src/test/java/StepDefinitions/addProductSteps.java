package StepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class addProductSteps {
    private WebDriver webDriver;
    private LoginPage loginPage;
    private HomePage homePage;
    private ExtentTest test;
    private ExtentReports extent;
    private String baseUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @Before
    public void setup() {

        ExtentHtmlReporter html = new ExtentHtmlReporter("target/Extent.html");
        extent =  new ExtentReports();
        extent.attachReporter(html);

        test = extent.createTest("AddProduct", "Test add product to cart functionality");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }
    @Given("user is on login page")
    public void user_is_on_login_page() {
        test.log(Status.INFO, "Starting Test Case");

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.navigate().to(baseUrl);

        test.pass("User is on login page");
    }
    @When("user enters email and password")
    public void user_enters_email_and_password() {
        loginPage = new LoginPage(webDriver);

        loginPage.enterEmail("thanhthanh@gmail.com");
        loginPage.enterPassword("thanhthanh");
        test.pass("User entered email and password");
    }
    @And("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickLogin();
        test.pass("User entered email and password");
    }
    @Then("user is navigated to the account page")
    public void user_is_navigated_to_the_account_page() {
        loginPage.LogoutButtonIsDisplayed();
        test.pass("Navigated to the account page");
    }
    @Given("user is on home page")
    public void user_is_on_home_page() {
        homePage = new HomePage(webDriver);
        homePage.navigatedToHomePage();
        test.pass("user on home page");
    }
    @When("^user hovers on (.*) and click Add to cart$")
    public void user_hovers_on_item_and_click_add_to_cart(String item) throws InterruptedException {
        homePage.hoverOnItem(item);
        test.pass("User hovered on "+item+" and click Add to cart button");
    }

    @Then("the item is added to cart")
    public void the_item_is_added_to_cart() throws InterruptedException {
        homePage.AddedModalIsDisplayed();
        Thread.sleep(3000);
        test.pass("The item is added to cart");

        test.info("Test is completed");

        extent.flush();

    }
    @After
    public void end() {
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }
    }
}
