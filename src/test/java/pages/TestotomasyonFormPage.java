package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class TestotomasyonFormPage {

    public TestotomasyonFormPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "(//select[@class='form-control'])[1]")
    public WebElement gunDrapdownMenu;

    @FindBy(xpath = "(//select[@class='form-control'])[2]")
    public WebElement ayDrapdownMenu;

    @FindBy(xpath = "(//select[@class='form-control'])[3]")
    public WebElement yilDrapdownMenu;


}
