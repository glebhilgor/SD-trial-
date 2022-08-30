package Tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutTest extends BaseTest{

    @Test
    public void checkOutInformation(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        cartPage.clickCart();
        checkoutPage.checkoutFilling("user", "user", "12345");
        assertTrue(driver.findElement(By.cssSelector(".summary_info")).isDisplayed());

    }
    @Test
    public void emptyFirstnameCheckout(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.toCheckoutButton();
        checkoutPage.checkoutFilling("", "user", "12345");
        assertEquals(checkoutPage.getError(), "Error: First Name is required");
    }
    @Test
    public void emptyLastnameCheckout(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.toCheckoutButton();
        checkoutPage.checkoutFilling("user", "", "12345");
        assertEquals(checkoutPage.getError(), "Error: Last Name is required");
    }
    @Test
    public void emptyPostalcodeCheckout(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.toCheckoutButton();
        checkoutPage.checkoutFilling("user", "user", "");
        assertEquals(checkoutPage.getError(), "Error: Postal Code is required");
    }
    @Test
    public void checkoutCancellationTest(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.toCheckoutButton();
        checkoutPage.cancelClick();
        try {
            assertTrue(driver.findElement(By.cssSelector(".summary_info")).isDisplayed());
        } catch (NoSuchElementException e) {
            System.out.println("There is no any info about shipping and cost data");
        } assertEquals(cartPage.checkPrice("Sauce Labs Backpack"), "$29.99", "Wrong cost");

    }
}
