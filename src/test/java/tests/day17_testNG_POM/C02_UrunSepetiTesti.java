package tests.day17_testNG_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.Reader;

public class C02_UrunSepetiTesti {

    @Test
    public void urunSepetiTesti() {

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- phone için arama yapın
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
        //3- Listelenen sonuçlardan ilkini tıklayın
        testOtomasyonPage.bulunanUrunElementleriList.get(0).click();

        //4- ürün ismini kaydedin ve sepete ekleyin
        String urunSayfasindakiUrunIsmi = testOtomasyonPage.urunSayfasindaUrunIsimElementi.getText();
        testOtomasyonPage.addToCartButonu.click();

        //5- your cart linkine tıklayın
        testOtomasyonPage.yourCart.click();

        //6- kaydettiğiniz ürün ismi ile sepetteki ürün isminin aynı olduğunu test edin
        String sepettekiUrunIsmi = testOtomasyonPage.sepettekiUrunIsimElementi.getText();
        Assert.assertEquals(sepettekiUrunIsmi, urunSayfasindakiUrunIsmi);

        //7- sayfayı kapatın
        Driver.quitDriver();


    }

}
