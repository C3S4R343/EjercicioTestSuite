package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class cartPage extends Base{

    public cartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Inicializamos elementos
    @FindBy(xpath = "//button[contains(@name,'checkout')]")
    WebElement btnChcekout;

    //Metodo para buscar todos los elementos en cart_item
    public boolean revisarElementos(){
    List<WebElement> cartItems = driver.findElements(By.className("cart_list"));
        return true;
    }

    //Metodo para hacer click en boton checkout
    public void checkOut(){
        if (revisarElementos()){
            btnChcekout.click();
        }else{
            Assert.assertTrue(revisarElementos(),"No hay elementos en la lista");
        }
    }
}
