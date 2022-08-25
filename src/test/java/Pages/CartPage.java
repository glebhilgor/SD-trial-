package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String checkPrice(String product) {
        String locator = String.format("//div[text()='%s'//ancestor::div[@class='cart_item']/" +
                "/div[@class='inventory_item_price", product);
        return driver.findElement(By.xpath(locator)).getText();

    }
}
