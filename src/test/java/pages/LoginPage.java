package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage {

    private String urlLogin = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private String titleLogin = "Login - My Store";

    @FindBy(id = "email")
    private WebElement txt_email;

    @FindBy(id = "passwd")
    private WebElement txt_password;

    @FindBy(id = "SubmitLogin")
    private WebElement btn_login;

    @FindBy(className = "logout")
    private WebElement btn_logout;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = titleLogin;
        this.PAGE_URL = urlLogin;

        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
        PageFactory.initElements(factory, this);
    }

    public void enterEmail(String email) {
        setElementText(txt_email, email);
    }

    public void enterPassword(String password) {
        setElementText(txt_password, password);
    }

    public void clickLogin() {
        clickElement(btn_login);
    }

    public void LogoutButtonIsDisplayed() {
        elementDisplayed(btn_logout);
    }
}
