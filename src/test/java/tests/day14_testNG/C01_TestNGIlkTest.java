package tests.day14_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_TestNGIlkTest extends TestBase {

    @Test
    public void aramaTesti() {

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda ürün bulunabildiğini test edin
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));

        String unExpectedAramaSonucYazisi = "0 Products Found";
        String actualAramaSonucYazisi = aramaSonucElementi.getText();

        Assert.assertNotEquals(actualAramaSonucYazisi, unExpectedAramaSonucYazisi);

    }

}
