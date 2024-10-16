package tests.day16_TestNG_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_PageClassKullanimi {

    @Test(groups = {"smoke", "regression"})
    public void aramaTesti() {
        //1- testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");
        //2- phone için arama yapın
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
        //3- Arama sonucunda bulunan ürün sayısının 3'den çok olduğunu test edin
        int actualSonucSayisi = testOtomasyonPage.bulunanUrunElementleriList.size();
        int expectedMinSonucSayisi = 3;

        Assert.assertTrue(actualSonucSayisi > expectedMinSonucSayisi);

        //4- ilk ürünü tıklayın
        testOtomasyonPage.bulunanUrunElementleriList.get(0).click();

        //5- açılan ürün sayfasında, ürün isminde case sensitive olmadan phone bulunduğunu test edin.
        String expectedUrunIsimIcerigi = "phone";
        String actualUrunIsmiKucukHarf = testOtomasyonPage.urunSayfasindaUrunIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualUrunIsmiKucukHarf.contains(expectedUrunIsimIcerigi));

        ReusableMethods.bekle(3);
        Driver.quitDriver();

    }

}
