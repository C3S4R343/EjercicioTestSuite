import Pages.Base;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); // Sin .exe en macOS/Linux
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver); // Inicialización correcta de LoginPage
    }

    @Test
    public void verifyElementsLogin(){
        loginPage.elementsVisible();
    }

    @Test
    public void testLogin() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Cierra el navegador después de la prueba
        }
    }
}
