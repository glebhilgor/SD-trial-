package Tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutFinalTest extends BaseTest{
    @Test
    public void buyItem(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isOpened());
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.toCheckoutButton();
        checkoutPage.checkoutFilling("user", "user", "12345");
        cartPage.finishClick();
        assertTrue(driver.findElement(By.id("checkout_comlpete_container")).isDisplayed(),
                "No any messages about successful buy");
    }
    @Test
    public void checkTotalCost(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isOpened());
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.toCheckoutButton();
        checkoutPage.checkoutFilling("user", "user", "12345");
        assertEquals(checkoutFinalPage.getTax(), "Tax: $2.40");
        assertEquals(checkoutFinalPage.getItemTotal(), "Item total: $29.99");
        assertEquals(checkoutFinalPage.getTotalCost(), "Total: 32.39");

    }
}
