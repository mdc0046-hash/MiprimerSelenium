package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;
import pages.InventoryPage;

public class InventoryTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;


    //Esta metodo se ejecutara antes de cualquier prueba, esta basicamente peara abrir la ventana y registrarse dentro de la pagina con el "standart_user".
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    //Este metodo se ejecutara al final de cada prueba, basicamente esta para cerrar la ventana.
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    //Esta prueba
    @Test
    public void anadirUnProductoAlCarrito() {
        inventoryPage.anadirProducto("Sauce Labs Backpack");
        assertEquals(1, inventoryPage.obtenerCantidadCarrito());
    }

    @Test
    public void anadirDosProductosAlCarrito() {
        inventoryPage.anadirProducto("Sauce Labs Backpack");
        inventoryPage.anadirProducto("Sauce Labs Bike Light");
        assertEquals(2, inventoryPage.obtenerCantidadCarrito());
    }

    @Test
    public void botonCambiaTrasAnadirProducto() {
        inventoryPage.anadirProducto("Sauce Labs Backpack");
        assertTrue(inventoryPage.botonCambiaARemove("Sauce Labs Backpack"));
    }
}
