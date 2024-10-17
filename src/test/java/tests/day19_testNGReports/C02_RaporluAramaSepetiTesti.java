package tests.day19_testNGReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_RaporluAramaSepetiTesti extends TestBaseRapor {

    @Test
    public void aramaSepetiTesti() {

        extentTest = extentReports.createTest("arama sepeti testi", "sepete attigimiz urun ismi ile sepetteki isim ayni olmali");


        //1- https://www.testotomasyonu.com/ anasayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        //2- phone için arama yapın
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
        extentTest.info("phone icin arama yapar");

        //3- Listelenen sonuçlardan ilkini tıklayın
        testOtomasyonPage.bulunanUrunElementleriList.get(0).click();
        extentTest.info("Listelenen sonuclardan ilkini tiklar");

        //4- ürün ismini kaydedin ve sepete ekleyin
        String sayfadakiUrunIsmi = testOtomasyonPage.urunSayfasindaUrunIsimElementi.getText();
        testOtomasyonPage.addToCartButonu.click();
        extentTest.info("urun ismini kaydeder ve sepete ekler");

        //5- your cart linkine tıklayın
        testOtomasyonPage.yourCart.click();
        extentTest.info("your cart linkine tiklar");

        //6- kaydettiğiniz ürün ismi ile sepetteki ürün isminin aynı olduğunu test edin
        String sepettekiUrunIsmi = testOtomasyonPage.sepettekiUrunIsimElementi.getText();
        ReusableMethods.bekle(1);
        Assert.assertEquals(sepettekiUrunIsmi, sayfadakiUrunIsmi);
        extentTest.pass("kaydettigi urun ismi ile sepetteki urun isminin ayni oldugunu test eder");

        //7- sayfayı kapatın
        Driver.quitDriver();
        extentTest.info("sayfayi kapatir");

    }

}
