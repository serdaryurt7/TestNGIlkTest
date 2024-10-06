package tests.day16_TestNG_POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C04_ToFormTesti {

    @Test
    public void formTesti() {
        //1- https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get("https://testotomasyonu.com/form");

        //2- Doğum tarihi gün dropdown menüden index kullanarak 5'i seçin
        TestotomasyonFormPage testotomasyonFormPage = new TestotomasyonFormPage();

        Select selectGun = new Select(testotomasyonFormPage.gunDrapdownMenu);
        selectGun.selectByIndex(5);

        //3- Doğum tarihi ay dropdown menüden value kullanarak Nisan'ı seçin
        Select selectAy = new Select(testotomasyonFormPage.ayDrapdownMenu);
        selectAy.selectByValue("nisan");

        //4- Doğum tarihi yıl dropdown menüden visible text kullanarak 1990'ı seçin
        Select selectYil = new Select(testotomasyonFormPage.yilDrapdownMenu);
        selectYil.selectByVisibleText("1990");

        //5- Seçilen değerleri konsolda yazdırın
        System.out.println(selectGun.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());

        //6- Ay dropdown menüdeki tüm değerleri(value) yazdırın
        List<WebElement> ayDropdownTumOpsiyonElementleri = selectAy.getOptions();

        System.out.println(ReusableMethods.stringListeCevir(ayDropdownTumOpsiyonElementleri));

        //7- Ay Dropdown menüsünün boyutunun 13 olduğunu test edin
        Assert.assertEquals(ayDropdownTumOpsiyonElementleri.size(), 13);

        ReusableMethods.bekle(10);
        Driver.quitDriver();


    }

}
