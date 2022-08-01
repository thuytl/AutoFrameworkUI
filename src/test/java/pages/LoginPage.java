package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
    WebDriver driver;
    @FindBy(id = "email")
    WebElement txt_email;

    @FindBy(id = "passwd")
    WebElement txt_password;

    @FindBy(id = "SubmitLogin")
    WebElement btn_login;

    @FindBy(className = "logout")
    WebElement btn_logout;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
        PageFactory.initElements(factory, this);
    }

    public void enterEmail(String email) {
        txt_email.sendKeys(email);
    }

    public void enterPassword(String password) {
        txt_password.sendKeys(password);
    }

    public void clickLogin() {
        btn_login.click();
    }

    public void LogoutButtonIsDisplayed() {
        btn_logout.isDisplayed();
    }
}
