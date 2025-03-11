package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends Base {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this); // Inicializa los elementos de la página
    }

    // Elementos en la página de login
    @FindBy(xpath = "//div[@class='login_logo']")
    private WebElement logo;

    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement btnLogin;

    // Método para hacer login con parámetros correctos
    public void login(String username, String password) {
        writeText(userNameField, username); // Usar el argumento en lugar de valores fijos
        writeText(passwordField, password);
        click(btnLogin);
    }

    //Metodo para verificar que elementos son visibles
    public void elementsVisible(){
        Assert.assertTrue(logo.isDisplayed(),"Logo visible");
    }
}
