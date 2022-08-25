package Tests;

import Pages.LoginPage;
import Pages.ProductsPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {


    @Test
    public void successfulLoginTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.isOpened(), "Title of the page is not displayed");

    }

    @Test
    public void wrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "shitball");
        assertEquals(loginPage.getError(),
                "Epic sadface: Username and password do not match any user in this service",
                "Wrong error message shows"
        );
    }

    @Test
    public void emptyUserName() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getError(),
                "Epic sadface: Username is required",
                "Wrong error message shows"
        );
    }

    @Test
    public void capsUserName() {
        loginPage.open();
        loginPage.login("STANDARD_USER", "secret_sauce");
        assertEquals(loginPage.getError(),
                "Epic sadface: Username and password do not match any user in this service",
                "Wrong error message shows"
        );

    }
}
