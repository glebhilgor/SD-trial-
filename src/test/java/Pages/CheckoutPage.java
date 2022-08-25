package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

private By
    CheckoutPage(WebDriver driver) {
        super(driver);
    }

public void checkoutOpen () {
        driver.get(BASE_URL + "checkout-step-one.html");
}

}
