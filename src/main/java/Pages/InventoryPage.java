package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class InventoryPage extends Base{

    public InventoryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(.,'Open Menu')]")
    private WebElement menu;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cart;

    public void verifyMenu(){
        Assert.assertTrue(menu.isDisplayed(), "Menu no esta disponible");
    }

    public void verifyCorrectPage(String url){
        assertCurrentUrl(url);
    }

    public void verifyCart(){
        if(!cart.getText().equals(" ")){
            cart.click();
        }else{
            Assert.assertEquals(cart.getText(),"3","carrito vacio");
        }
    }
    public void enlistarElementos() {
        // Obtener todos los botones "Agregar al carrito" en la página
        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[contains(@data-test, 'add-to-cart')]"));

        // Crear un conjunto para almacenar los índices de los productos seleccionados sin repetir
        Set<Integer> selectedIndexes = new HashSet<>();
        Random random = new Random(); // Crear un objeto Random para seleccionar productos al azar

        // Seleccionar 3 productos diferentes al azar
        while (selectedIndexes.size() < 3) {
            int index = random.nextInt(addToCartButtons.size()); // Generar un índice aleatorio dentro del rango de la lista de botones
            selectedIndexes.add(index); // Agregar el índice al conjunto (evita duplicados automáticamente)
        }

        // Hacer clic en los botones de los productos seleccionados
        for (int index : selectedIndexes) {
            addToCartButtons.get(index).click(); // Se obtiene el botón según el índice y se hace clic en él
        }
    }

}
