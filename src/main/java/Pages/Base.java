/*
Beneficios clase base
Reutilización de código: Métodos comunes como clics, escritura en campos y validaciones se centralizan aquí.
Manejo de esperas (WebDriverWait): Evita fallos por carga lenta de elementos.
Estandarización: Facilita la implementación de nuevas páginas con consistencia.
Manejo de errores: Implementa excepciones personalizadas en caso de fallos.
 */

package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Base {
    protected WebDriver driver; // Instancia de WebDriver accesible para clases hijas
    protected WebDriverWait wait; // WebDriverWait para gestionar esperas explícitas

    // Constructor de la clase Base
    public Base(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Tiempo máximo de espera: 5 segundos
        PageFactory.initElements(driver, this); // Inicializa los elementos @FindBy en la clase que hereda de Base
    }

    // 🕒 Método para esperar hasta que un elemento sea visible en la página
    private WebElement waitForElementVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // 🕒 Método para esperar hasta que un elemento sea clickeable
    private WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // 🖱️ Método para hacer click en un elemento con manejo de errores
    protected void click(WebElement element) {
        try {
            waitForElementToBeClickable(element).click(); // Espera a que el elemento esté disponible antes de hacer click
        } catch (Exception e) {
            throw new RuntimeException("No se pudo hacer click en el elemento"); // Manejo de errores si el elemento no está disponible
        }
    }

    // ⌨️ Método para escribir texto en un campo con validación previa
    protected void writeText(WebElement element, String text) {
        WebElement el = waitForElementVisible(element); // Asegura que el elemento es visible antes de escribir
        el.clear(); // Borra cualquier texto existente en el campo
        el.sendKeys(text); // Ingresa el nuevo texto
    }

    // 🔍 Verificar que un elemento esté visible sin fallar abruptamente
    protected void assertElementVisible(WebElement element) {
        try {
            waitForElementVisible(element); // Espera hasta que el elemento sea visible
            Assert.assertTrue(element.isDisplayed(), "El elemento no es visible");
        } catch (Exception e) {
            throw new AssertionError("No se encontró el elemento esperado");
        }
    }

    // 🔗 Verificar que la URL actual sea la esperada
    protected void assertCurrentUrl(String expectedUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "La URL no es correcta");
    }
}
