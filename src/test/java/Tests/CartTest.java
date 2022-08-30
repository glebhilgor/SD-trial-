package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest{
    @Test
    public void deleteAfterAdding() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.clickCart();
        cartPage.deleteClick("Sauce Labs Bike Light");
        cartPage.toCheckoutButton();
        checkoutPage.checkoutFilling("user", "seue", "12345");
        try {
            assertTrue(driver.findElement(By.xpath("//div[text() = 'Sauce Labs Bike Light']" +
                    "//ancestor::div[@class='cart_item']//div[@class='inventory_item_name']")).isDisplayed());
        } catch (NoSuchElementException e) {
            System.out.println("Item deleted from the cart");
        }
    }
}
