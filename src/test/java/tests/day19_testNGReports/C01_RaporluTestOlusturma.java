package tests.day19_testNGReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C01_RaporluTestOlusturma extends TestBaseRapor {

    @Test
    public void aramaTesti(){

        // test otomasyonu ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // testotomasyonu sayfasına gittiğinizi test edin
        String expectedUrl = ConfigReader.getProperty("toUrl") + "/asdf";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualUrl, expectedUrl, "URL testi failed"); // 1.assertion


        // phone için arama yapın
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // bulunan ürün sayısının 3'den fazla olduğunu test edin
        int expectedMinUrunSayisi = 33;
        int actualUrunSayisi = testOtomasyonPage.bulunanUrunElementleriList.size();

        // Assert.assertTrue(actualUrunSayisi > expectedMinUrunSayisi);
        softAssert.assertTrue(actualUrunSayisi > expectedMinUrunSayisi, "Urun sayisi testi failed"); // 2.assertion

        // ilk ürüne tıklayın
        ReusableMethods.bekle(2);
        testOtomasyonPage.bulunanUrunElementleriList.get(0).click();

        // açılan ürün sayfasında, ürün isminin
        // case sensitive olmadan phone içerdiğini test edin

        String expectedUrunIsimIcerik = "phoneDDD";
        String actualUrunIsmiKucukHarf = testOtomasyonPage.urunSayfasindaUrunIsimElementi.getText().toLowerCase();

        // Assert.assertTrue(actualUrunIsmiKucukHarf.contains(expectedUrunIsimIcerik));
        softAssert.assertTrue(actualUrunIsmiKucukHarf.contains(expectedUrunIsimIcerik), "Urun ismi testi failed");

        softAssert.assertAll();

        // sayfayı kapatın

        Driver.quitDriver();

    }

}
