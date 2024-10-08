package tests.day17_testNG_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_Assertions {

    @Test
    public void aramaTesti() {

        // test otomasyonu ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // testotomasyonu sayfasına gittiğinizi test edin
        String expectedUrl = ConfigReader.getProperty("toUrl") + "/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);

        // phone için arama yapın
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // bulunan ürün sayısının 3'den fazla olduğunu test edin
        int expectedMinUrunSayisi = 3;
        int actualUrunSayisi = testOtomasyonPage.bulunanUrunElementleriList.size();

        Assert.assertTrue(actualUrunSayisi > expectedMinUrunSayisi);

        // ilk ürüne tıklayın
        ReusableMethods.bekle(2);
        testOtomasyonPage.bulunanUrunElementleriList.get(0).click();

        // açılan ürün sayfasında, ürün isminin
        // case sensitive olmadan phone içerdiğini test edin

        String expectedUrunIsimIcerik = "phone";
        String actualUrunIsmiKucukHarf = testOtomasyonPage.urunSayfasindaUrunIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualUrunIsmiKucukHarf.contains(expectedUrunIsimIcerik));
        // sayfayı kapatın

        Driver.quitDriver();

    }
}
