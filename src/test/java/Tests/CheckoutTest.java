package Tests;

import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest{

    @Test
    public void checkOutInformation(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.clickCart();

    }
}
