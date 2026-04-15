package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;

public class LoginTest {

        private WebDriver driver;
        private LoginPage loginPage;

        @BeforeEach
        public void setUp() {
                driver = new ChromeDriver();
                driver.get("https://www.saucedemo.com/");
                loginPage = new LoginPage(driver);
        }

        @AfterEach
        public void tearDown() {
                driver.quit();
        }

        @Test
        public void loginCorrecto() {
                loginPage.login("standard_user", "secret_sauce");
                assertTrue(driver.getCurrentUrl().contains("inventory"));
        }

        @Test
        public void loginIncorrecto() {
                loginPage.login("standard_user", "password_mal");
                assertTrue(loginPage.obtenerMensajeError().contains("Epic sadface"));
        }
}
