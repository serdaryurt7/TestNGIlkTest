package tests.day17_testNG_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import pages.ToAddRemovePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_SwitchingWindows {

    @Test
    public void windowTesti() {


        // https://testotomasyonu.com/addremove/ adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("toAddUrl"));

        // Sayfadaki textin "Add/Remove Elements" olduğunu doğrulayın.

        String expectedYazi = "Add/Remove Elements";

        ToAddRemovePage toAddRemovePage = new ToAddRemovePage();
        String actualYazi = toAddRemovePage.addRemoveYaziElementi.getText();

        Assert.assertEquals(actualYazi, expectedYazi);

        // Sayfa başlığının(title) "Test Otomasyonu" olduğunu doğrulayın.

        String expectedTitle = "Test Otomasyonu";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
        String addRemoveSayfasiWhd = Driver.getDriver().getWindowHandle();

        // 'Please click for Electronics Products' linkine tıklayın.
        toAddRemovePage.electronicsLinki.click();

        // Electronics sayfasının açıldığını test edin.

        // link tıklandığında electronics sayfası ayrı bir tab olarak açılıyor
        // önce webDriver objemizi o window'a geçirmeliyiz

        ReusableMethods.titleIleWindowDegistir("Test Otomasyonu - Electronics", Driver.getDriver());

        Assert.assertTrue(toAddRemovePage.electronicsSayfasiDogrulama.isDisplayed());

        // Bulunan ürün sayısının 16 olduğunu test edin
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();

        int expectedUrunSayisi = 16;
        int actualUrunSayisi = toAddRemovePage.bulunanUrunElementleriList.size();

        Assert.assertEquals(actualUrunSayisi, expectedUrunSayisi);

        // Ilk açtığınız addremove sayfasına dönün

        Driver.getDriver().switchTo().window(addRemoveSayfasiWhd);

        // Url'in addremove içerdiğini test edin.

        String expectedUrlIcerik = "addremove";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        Driver.quitDriver();

    }

}
