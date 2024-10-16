package tests.day16_TestNG_POM;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_FacebookNegatifLoginTesti {

    @Test(groups = {"smoke", "e2e"})
    public void faceBookNegatifLoginTesti() {

        //1- https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");
        //   cookies çıkıyorsa kabul edin
        //--------------------------------------------------------------------------------
        FacebookPage facebookPage = new FacebookPage();
        ReusableMethods.bekle(1);

        //2- POM'a uygun olarak email, şifre kutularını ve giriş yap butonunu locate edin
        //3- Faker class'ını kullanarak email ve şifre değerlerini yazdırıp, giriş butonuna basın
        Faker faker = new Faker();

        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordKutusu.sendKeys(faker.internet().password());

        facebookPage.loginButonu.click();
        ReusableMethods.bekle(3);
        //4- Başarılı giril yapılmadığını test edin
        Assert.assertTrue(facebookPage.girisYapilamadiYaziElementi.isDisplayed());

        Driver.quitDriver();


    }

}
