package tests.day16_TestNG_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_PageClassIlePozitifLoginTesti {

    @Test
    public void pozitifLoginTesti() {

        //1- https://www.testotomasyonu.com/ anasayfasına gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");
        //2- account linkine basın

        //POM'de page class'larında locate ettiğimiz webElementlere ulaşmak için
        // PageClass'larından obje oluştururuz

        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.accountLinki.click();

        //3- Kullanıcı email'i olarak "wise@gmail.com" girin
        testOtomasyonPage.emailKutusu.sendKeys("wise@gmail.com");

        //4- Kullanıcı şifresi olarak "12345" girin
        testOtomasyonPage.passwordKutusu.sendKeys("12345");

        //5- Login butonuna basarak login olun
        testOtomasyonPage.loginButonu.click();

        //6- Başarılı olarak giriş yapılabildiğini test edin
        Assert.assertTrue(testOtomasyonPage.logoutButonu.isDisplayed());
        ReusableMethods.bekle(5);
        Driver.quitDriver();


    }

}
