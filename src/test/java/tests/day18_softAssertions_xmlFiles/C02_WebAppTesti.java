package tests.day18_softAssertions_xmlFiles;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C02_WebAppTesti {

    @Test
    public void test01() {
        // 1. "http://zero.webappsecurity.com/" adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));
        // 2. webappsecurity ana sayfaya gittiğinizi doğrulayın

        String expectedUrl = ConfigReader.getProperty("zeroUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualUrl, expectedUrl, "Url testi FAILED");

        // 3. Sign in butonuna basın
        ZeroWebPage zeroWebPage = new ZeroWebPage();
        zeroWebPage.signInLinki.click();


        // 4. Login kutusuna "username" yazın
        zeroWebPage.usernameKutusu.sendKeys(ConfigReader.getProperty("zeroGecerliUsername"));

        // 5. Password kutusuna "password" yazın
        zeroWebPage.passwordKutusu.sendKeys(ConfigReader.getProperty("zeroGecerliPassword"));

        // 6. Sign in tuşuna basın
        zeroWebPage.signInButonu.click();

        // 7. Back tuşuna basın
        Driver.getDriver().navigate().back();

        // 8. Giriş yapılabildiğini doğrulayın
        softAssert.assertTrue(zeroWebPage.loginDogrulama.isDisplayed(), "Giris yapildi testi FAILED");

        // 9. Online banking menusunu tıklayın
        zeroWebPage.onlineBankingLinki.click();

        //10. Pay Bills sayfasına gidin
        zeroWebPage.payBillsLinki.click();

        //11. "Purchase Foreign Currency" tuşuna basın
        zeroWebPage.purchaseForeignCurrencyTab.click();

        //12. Currency dropdown menusunun erişilebilir olduğunu doğrulayın
        softAssert.assertTrue(zeroWebPage.pcCurrencyDropdown.isEnabled());

        //13. "Currency" dropdown menusunden Eurozone'u seçin
        Select select = new Select(zeroWebPage.pcCurrencyDropdown);
        select.selectByValue("EUR");

        //14. "Eurozone (euro) seçildiğini doğrulayın"
        String expectedSecilenOption = "Eurozone (euro)";
        String actualSecilenOption = select.getFirstSelectedOption().getText();

        softAssert.assertEquals(actualSecilenOption, expectedSecilenOption, "Eurozone secim testi FAILED");

        //15. Dropdown menude 16 option bulunduğunu doğrulayın
        int expectedOptionSayisi = 16;
        int actualOptionSayisi = select.getOptions().size();

        softAssert.assertEquals(actualOptionSayisi, expectedOptionSayisi, "dropdown option sayi testi FAILED");

        //16. Dropdown menude "Canada (dollar)" bulunduğunu doğrulayın
        List<WebElement> dropdownOptionElementleriList = select.getOptions(); //List olarak aldık
        List<String> dropdownOptionsListesi = ReusableMethods.stringListeCevir(dropdownOptionElementleriList); //String liste çevirdik

        String expectedOptionIcerik = "Canada (dollar)";

        softAssert.assertTrue(dropdownOptionsListesi.contains(expectedOptionIcerik), "Canada testi FAILED");

        softAssert.assertAll();
        //17. Sayfayı kapatın

        Driver.quitDriver();


    }

}
