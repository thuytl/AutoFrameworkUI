package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public WebDriver webDriver;
    public String PAGE_URL;
    public String PAGE_TITLE;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void loadPage() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.navigate().to(getPageUrl());
        Assert.assertEquals(webDriver.getTitle(), getPageTitle());
    }

    public void setElementText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
    }

    public void clickElement(WebElement element) {
        element.isEnabled();
        element.click();
    }

    public void elementDisplayed(WebElement element) {
        element.isDisplayed();
    }

    public void hoverOnElement( String text, String textOfButton) throws InterruptedException {
        WebElement linkText = webDriver.findElement(new By.ByLinkText(text));
        Actions action = new Actions(webDriver);
        action.moveToElement(linkText).build().perform();
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(textOfButton)));

        By btn_add = By.linkText(textOfButton);

        WebElement addBtn = findWebElement(btn_add);

        action.moveToElement(addBtn);
        action.click().build().perform();
        Thread.sleep(3000);
    }
    public WebElement findWebElement(By element) {
        return webDriver.findElement(element);
    }

    public String getPageUrl(){
        return PAGE_URL;
    }

    public String getPageTitle() {
        return PAGE_TITLE;
    }
}
