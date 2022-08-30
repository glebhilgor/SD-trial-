package Tests;

import Pages.BasePage;
import Pages.CartPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductTest extends BaseTest {

    @Test
    public void cartProductPriceInCartShouldBeCorrect() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isOpened());
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        assertTrue(cartPage.isOpened());
        assertEquals(cartPage.checkPrice("Sauce Labs Backpack"), "$29.99",
                "Product price is not correct");
    }
}
