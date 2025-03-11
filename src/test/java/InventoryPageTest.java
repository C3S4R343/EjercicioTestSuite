import Pages.InventoryPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); // Sin .exe en macOS/Linux
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);// Inicialización correcta de LoginPage
        inventoryPage = new InventoryPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void veirfyAllElements() {
        inventoryPage.verifyCorrectPage("https://www.saucedemo.com/inventory.html");
        inventoryPage.verifyMenu();
    }

    @Test
    public void procesoCompra(){
        inventoryPage.enlistarElementos();
        inventoryPage.verifyCart();
    }

   /* @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Cierra el navegador después de la prueba
        }
    }*/
}
