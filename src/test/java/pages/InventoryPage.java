package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;

    private By cartBadge = By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void anadirProducto(String nombreProducto) {
        String xpath = "//div[text()='" + nombreProducto + "']/ancestor::div[@class='inventory_item']//button";
        driver.findElement(By.xpath(xpath)).click();
    }

    public int obtenerCantidadCarrito() {
        try {
            return Integer.parseInt(driver.findElement(cartBadge).getText());
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean botonCambiaARemove(String nombreProducto) {
        String xpath = "//div[text()='" + nombreProducto + "']/ancestor::div[@class='inventory_item']//button";
        return driver.findElement(By.xpath(xpath)).getText().equals("Remove");
    }
}
