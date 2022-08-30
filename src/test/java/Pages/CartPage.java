package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

static By CHECKOUT_BUTTON = By.id("checkout");
static By FINISH_BUTTON = By.id("finish");
private final By PAGE_TITLE = By.cssSelector(".title");


    public CartPage(WebDriver driver) {
        super(driver);
    }



    public String checkPrice(String product) {
        String locator = String.format("//div[text() = '%s']//ancestor::div[@class='cart_item']" +
                "//div[@class='inventory_item_price']", product);
        return driver.findElement(By.xpath(locator)).getText();

    }
    public String checkTitle(String title) {
        String locator = String.format("//div[text() = '%s']//ancestor::div[@class='cart_item']" +
                "//div[@class='inventory_item_name']", title);
        return driver.findElement(By.xpath(locator)).getText();

    }
    public void toCheckoutButton(){
        driver.findElement(CHECKOUT_BUTTON).click();
    }
    public void deleteClick(String title) {
        String locator = String.format("//div[text() = '%s']//ancestor::div[@class='cart_item']" +
                "//button[@id='remove-sauce-labs-bike-light']", title);
        driver.findElement(By.xpath(locator)).click();
    }
    public void finishClick(){
        driver.findElement(FINISH_BUTTON).click();
    }
    public boolean isOpened(){
        return waitForVisibility(PAGE_TITLE);
    }
}
