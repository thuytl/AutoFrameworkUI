package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private String urlHome = "http://automationpractice.com/index.php";
    private String titleHome = "My Store";

    private By modal = By.id("layer_cart");

    public HomePage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = urlHome;
        this.PAGE_TITLE = titleHome;
    }

//    public void navigatedToHomePage(){
//        loadPage();
//    }

    public void hoverOnItem(String item) throws InterruptedException {

        hoverOnElement(item, "Add to cart");
    }

    public void AddedModalIsDisplayed() {
        WebElement modalElement = findWebElement(modal);
        elementDisplayed(modalElement);
    }

}
