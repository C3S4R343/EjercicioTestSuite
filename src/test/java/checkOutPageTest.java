import Pages.InventoryPage;
import Pages.LoginPage;
import Pages.cartPage;
import Pages.checkOutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class checkOutPageTest {
    private WebDriver driver;
    private LoginPage logPage;
    private InventoryPage invPage;
    private cartPage cart;
    private checkOutPage checkP;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); // Sin .exe en macOS/Linux
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        logPage = new LoginPage(driver);
        invPage = new InventoryPage(driver);
        cart = new cartPage(driver);
        checkP = new checkOutPage(driver);
        logPage.login("standard_user", "secret_sauce");
        invPage.enlistarElementos();
        invPage.verifyCart();
        cart.checkOut();
    }

    @Test
    public void llenarInformacion(){
        checkP.checkElements();
        checkP.fillInformation("Cesar","Gonzalez","37800");
    }

}
