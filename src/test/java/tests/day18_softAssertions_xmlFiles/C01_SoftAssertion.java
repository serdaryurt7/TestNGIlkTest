package tests.day18_softAssertions_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_SoftAssertion {

    /*
        TestNG JUnit'deki assertion class'ının aynısına sahiptir.

        Ancak bu assertion'da, bir test method'unun içinde birden fazla assertion olduğunda
        ilk FAILED olan assertion'da kodların çalışması durduğu için,
        geriye kalan assertion'ların sonuçlarının görme şansımız OLMAZ

        EĞER birden fazla assertion olan bir test method'unda
        tüm assertion'ları yapıp,
        en sonda varsa failed tüm assertion'ları raporlamasını istersek
        TestNG'deki SoftAssert class'ını kullanabiliriz

        Soft assert 3 adımda çalıştırılır
        1- softAssert objesi oluşturma
        2- oluşturduğumuz obje üzerinden assertion'ları yapma
        3- assertAll() ile yapılan tüm assertion'ları raporlama

        softAssert hatayı assertAll() method'unun çalıştığı satırda raporlar
        birden fazla assertion olan bir method'da
        failed olan assertion'ı rahat bulabilmek için
        assertion kodlarına, mesaj da eklemek isabetli bir tercih olacaktır

        softAssert ile hazırlanan bir test method'unun sonunda
        assertAll() demezsek failed olan assertion olsa bile
        testimiz PASSED olur
     */

    @Test
    public void softAssertAramaTesti() {

        // test otomasyonu ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // testotomasyonu sayfasına gittiğinizi test edin
        String expectedUrl = ConfigReader.getProperty("toUrl") + "/asdf";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        // Assert.assertEquals(actualUrl, expectedUrl);
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
