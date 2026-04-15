package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {

        @Test
        void loginCorrecto() {
                LoginPage loginPage = new LoginPage(driver);

                loginPage.login("standard_user", "secret_sauce");

                assertTrue(driver.getCurrentUrl().contains("inventory"),
                        "El usuario debería entrar a la página de inventario tras un login correcto");
        }

        @Test
        void loginIncorrecto() {
                LoginPage loginPage = new LoginPage(driver);

                loginPage.login("standard_user", "clave_mal");

                assertTrue(driver.findElement(
                        org.openqa.selenium.By.cssSelector("[data-test='error']")
                ).isDisplayed(), "Debería mostrarse un mensaje de error al fallar el login");
        }
}
