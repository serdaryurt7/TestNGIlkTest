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
    public void aramaTesti() {

        /*
            Raporlu olmasını istediğimiz her test method'unda
            1- class'in TestbaseRapor'a child yapılması
            2- extentTest objesinin oluşturulması
            3- raporda cikmasini istedigimiz test adimlarini
               extentTest objesi ile işlemeliyiz
         */

        extentTest = extentReports.createTest("arama testi", "test otomasyonunda phone aranabilmeli");

        // test otomasyonu ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("kullanici test otomasyou ana sayfaya gider");

        // testotomasyonu sayfasına gittiğinizi test edin
        String expectedUrl = ConfigReader.getProperty("toUrl") + "/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualUrl, expectedUrl, "URL testi failed"); // 1.assertion
        extentTest.info("testotomasyonu sayfasina gittigini test eder");

        // phone için arama yapın
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
        extentTest.info("phone icin arama yapar");

        // bulunan ürün sayısının 3'den fazla olduğunu test edin
        int expectedMinUrunSayisi = 3;
        int actualUrunSayisi = testOtomasyonPage.bulunanUrunElementleriList.size();
        extentTest.info("bulunan urun sayısının 3'den fazla olduğunu test eder");

        // Assert.assertTrue(actualUrunSayisi > expectedMinUrunSayisi);
        softAssert.assertTrue(actualUrunSayisi > expectedMinUrunSayisi, "Urun sayisi testi failed"); // 2.assertion

        // ilk ürüne tıklayın
        ReusableMethods.bekle(2);
        testOtomasyonPage.bulunanUrunElementleriList.get(0).click();
        extentTest.info("ilk urune tiklar");

        // açılan ürün sayfasında, ürün isminin
        // case sensitive olmadan phone içerdiğini test edin

        String expectedUrunIsimIcerik = "phone";
        String actualUrunIsmiKucukHarf = testOtomasyonPage.urunSayfasindaUrunIsimElementi.getText().toLowerCase();
        extentTest.info("urun isminin case sensitive olmadan phone icerdigini test eder");

        // Assert.assertTrue(actualUrunIsmiKucukHarf.contains(expectedUrunIsimIcerik));
        softAssert.assertTrue(actualUrunIsmiKucukHarf.contains(expectedUrunIsimIcerik), "Urun ismi testi failed");
        ReusableMethods.bekle(2);
        softAssert.assertAll();
        extentTest.pass("softassert ile yapilan tum assertionlar raporlanir");
        // sayfayı kapatın

        Driver.quitDriver();
        extentTest.info("sayfayi kapatir");

    }

}
