package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void escribirUsuario(String usuario) {
        driver.findElement(usernameInput).sendKeys(usuario);
    }

    public void escribirPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void pulsarLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String usuario, String password) {
        escribirUsuario(usuario);
        escribirPassword(password);
        pulsarLogin();
    }

    public String obtenerMensajeError() {
        return driver.findElement(errorMessage).getText();
    }
}

