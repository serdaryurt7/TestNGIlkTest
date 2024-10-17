package tests.day20_dataProvider_crossBrowserTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.security.Key;

public class C01_DataProvider extends TestBaseRapor {
    @DataProvider
    public static Object[][] aranacakUrunlerProvider() {
        /*
                @DataProvider notasyonunu kullanan method'lar
                bize 2 katlı bir array döndürmek üzere hazırlanmıştır

                bu method'un içerisinde non-primitive data türüne sahip
                2 katlı bir array oluşturup
                bu array'i return olarak gönderirsek
                arraydeki her bir inner array'i sırasıyla
                test method'umuza parametre olarak gönderir
         */

        String[][] aranacakUrunlerArrayi = {{"phone"}, {"java"}, {"dress"}, {"apple"}, {"nutella"}, {"cokokrem"}, {"baby"}};

        return aranacakUrunlerArrayi;
    }

    // test otomasyonu anasayfaya gidin
    // verilen ürün listesindeki her bir ürün için
    // arama yapıp, arama sonucunda ürün bulunabildiğini test edin
    // aranacak ürün listesi : phone, java, dress, apple, nutella, cokokrem, baby

    @Test(dataProvider = "aranacakUrunlerProvider")
    public void topluAramaTesti(String aranacakUrun) {

        extentTest = extentReports.createTest("Toplu arama testi", "Verilen listedeki tum urunlerin stokta bulundugunu test eder");

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys(aranacakUrun);
        extentTest.info("arama kutusuna " + aranacakUrun + " yazar");

        ReusableMethods.bekle(2);
        testOtomasyonPage.aramaKutusu.submit();
        extentTest.info("aramayi kutusuna yazilan " + aranacakUrun + " icin arama yapar");
        ReusableMethods.bekle(2);

        String unExpectedSonucYazisi = "0 Products Found";

        Assert.assertFalse(testOtomasyonPage.bulunanUrunSayisiElementi.getText().equals(unExpectedSonucYazisi));
        extentTest.pass(aranacakUrun + "aramasinda urun bulunabildigini test eder");
        Driver.quitDriver();
        extentTest.info("sayfayi kapatir");


    }

}
