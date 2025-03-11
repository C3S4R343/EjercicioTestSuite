package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class checkOutPage extends Base{
    public checkOutPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "first-name")
    WebElement FirstName;

    @FindBy(id = "last-name")
    WebElement LastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement btnContinue;


    public void fillInformation(String firstName, String lastName, String ZP){
        writeText(FirstName, firstName);
        writeText(LastName, lastName);
        writeText(postalCode, ZP);
        click(btnContinue);
    }

    public void checkElements(){
        Assert.assertTrue(FirstName.isDisplayed(),"First name no esta presente");
        Assert.assertTrue(LastName.isDisplayed(),"last name no esta presente");
        Assert.assertTrue(postalCode.isDisplayed(),"Postal code no esta presente");
        Assert.assertTrue(FirstName.isDisplayed(),"First name no esta presente");
    }

}
