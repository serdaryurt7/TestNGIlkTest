package tests.day17_testNG_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_NegatifLoginTesti {

    //1- https://www.testotomasyonu.com/ anasayfasına gidin
    //2- account linkine basın
    //3- 3 farklı test method'u oluşturun
    // - geçerli email, geçersiz password
    // - geçersiz email, geçerli password
    // - geçersiz email, geçersiz password.
    //4- SignIn butonuna basarak login olun
    //5- Başarılı olarak giriş yapılamadığını test edin

    @Test(groups = {"smoke", "e2e", "regression"})
    public void gecersizPasswordTesti() {


        //1- https://www.testotomasyonu.com/ anasayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basın
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.accountLinki.click();

        //3- 3 farklı test method'u oluşturun
        // - geçerli email, geçersiz password
        testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- SignIn butonuna basarak login olun
        testOtomasyonPage.loginButonu.click();

        //5- Başarılı olarak giriş yapılamadığını test edin
        Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());

        Driver.quitDriver();

    }

    @Test(groups = "smoke")
    public void gecersizEmailTesti() {


        //1- https://www.testotomasyonu.com/ anasayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basın
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.accountLinki.click();

        //3- 3 farklı test method'u oluşturun
        // - geçersiz email, geçerli password
        testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        //4- SignIn butonuna basarak login olun
        testOtomasyonPage.loginButonu.click();

        //5- Başarılı olarak giriş yapılamadığını test edin
        Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());

        Driver.quitDriver();

    }

    @Test
    public void gecersizPasswordGecersizEmailTesti() {


        //1- https://www.testotomasyonu.com/ anasayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basın
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.accountLinki.click();

        //3- 3 farklı test method'u oluşturun
        // - geçersiz email, geçersiz password.
        testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- SignIn butonuna basarak login olun
        testOtomasyonPage.loginButonu.click();

        //5- Başarılı olarak giriş yapılamadığını test edin
        Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());

        Driver.quitDriver();

    }

}
