package tests.day16_TestNG_POM;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebuniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_WebuniversityTest {

    @Test
    public void webUniversitytest() {
        //1. "https://webdriveruniversity.com/" adresine gidin
        Driver.getDriver().get("https://webdriveruniversity.com/");

        String ilkSayfaWindowHandleDegeri = Driver.getDriver().getWindowHandle();
        //2. "Login Partal" a kadar aşağı inin
        // portal yazısına kadar aşağı inmek için JS Executor kullanalım
        WebuniversityPage webuniversityPage = new WebuniversityPage();

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        // javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", webuniversityPage.loginPortalElementi);

        ReusableMethods.bekle(1);
        //3. "Login Partal" a tıklayın
        webuniversityPage.loginPortalElementi.click();

        //4. Diğer window'a geçin
        ReusableMethods.titleIleWindowDegistir("WebDriver | Login Portal", Driver.getDriver());

        //5. "username" ve "password" kutularına değer yazdırın
        Faker faker = new Faker();
        webuniversityPage.usernameKutusu.sendKeys(faker.name().username());
        webuniversityPage.passwordKutusu.sendKeys(faker.internet().password());

        //6. "login" butonuna basın
        webuniversityPage.loginButonu.click();

        //7. Popup'ta çıkan yazının "validation failed" olduğunu test edin

        String expectedAlertYazisi = "validation failed";
        String actualAlertYazisi = Driver.getDriver().switchTo().alert().getText();

        Assert.assertEquals(actualAlertYazisi, expectedAlertYazisi);

        //8. Ok diyerek Popup'ı kapatın
        Driver.getDriver().switchTo().alert().accept();

        //9. Ilk sayfaya geri dönün
        Driver.getDriver().switchTo().window(ilkSayfaWindowHandleDegeri);


        //10. Ilk sayfaya dönüldüğünü test edin
        String expectedUrl = "https://webdriveruniversity.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);

        Driver.quitDriver();

    }
}
