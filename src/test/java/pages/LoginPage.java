package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By userField = By.id("user-name");
    private By passField = By.id("password");
    private By loginBtn = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ingresarUsuario(String user) {
        driver.findElement(userField).sendKeys(user);
    }

    public void ingresarPassword(String pass) {
        driver.findElement(passField).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    // Parte 5: método login completo
    public void login(String user, String pass) {
        ingresarUsuario(user);
        ingresarPassword(pass);
        clickLogin();
    }
}
