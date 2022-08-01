package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;

    private By modal = By.id("layer_cart");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigatedToHomePage(){
        driver.navigate().to("http://automationpractice.com/index.php");
    }

    public void hoverOnItem(String text) throws InterruptedException {
        WebElement linkText = driver.findElement(new By.ByLinkText(text));
        Actions action = new Actions(driver);
        action.moveToElement(linkText).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Add to cart")));
        By btn_add = By.linkText("Add to cart");

        WebElement addBtn = driver.findElement(btn_add);

        action.moveToElement(addBtn);
        action.click().build().perform();
        Thread.sleep(3000);
    }

    public void AddedModalIsDisplayed() {

        driver.findElement(modal).isDisplayed();
    }

}
