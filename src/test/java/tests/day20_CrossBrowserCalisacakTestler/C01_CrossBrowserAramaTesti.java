package tests.day20_CrossBrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C01_CrossBrowserAramaTesti extends TestBaseCross {

    @Test
    public void aramaTesti() {

        // testotomasyonu ana sayfaya gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        // phone için arama yapın

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda ürün bulunabildiğini test edin
        ReusableMethods.bekle(2);
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));
        ReusableMethods.bekle(2);
        String unExpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucElementi.getText();

        Assert.assertNotEquals(actualSonucYazisi, unExpectedSonucYazisi);

        ReusableMethods.bekle(5);

    }
}
