package tests.day16_TestNG_POM;

import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.Driver;

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
        //4- Kullanıcı şifresi olarak "12345" girin
        //5- Login butonuna basarak login olun
        //6- Başarılı olarak giriş yapılabildiğini test edin

    }

}
