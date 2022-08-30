package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public By FIRSTNAME_FIELD = By.id("first-name");
    public By LASTNAME_FIELD = By.id("last-name");
    public By POSTALCODE_FIELD = By.id("postal-code");
    public By CONTINUE_BUTTON = By.id("continue");
    public By CANCEL_BUTTON = By.id("cancel");
    public By ERROR_MESSAGE = By.cssSelector("h3[data-test-error]");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public void checkoutFilling(String firstName, String lastName, String postalCode) {
        driver.findElement(FIRSTNAME_FIELD).sendKeys(firstName);
        driver.findElement(LASTNAME_FIELD).sendKeys(lastName);
        driver.findElement(POSTALCODE_FIELD).sendKeys(postalCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }
    public void cancelClick() {
        driver.findElement(CANCEL_BUTTON).click();
    }
    public String getError() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
    public boolean isOpened() {
        return waitForVisibility(CONTINUE_BUTTON);
    }


}
