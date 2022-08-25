package Tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Locators extends BaseTest {

    @Test
    public void butProduct() {

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standart_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
    }
}
