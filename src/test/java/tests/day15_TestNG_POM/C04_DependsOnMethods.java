package tests.day15_TestNG_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class C04_DependsOnMethods {

    List<WebElement> bulunanUrunElementleriList;

    @Test(priority = 1)
    public void testOtomasyonAnaSayfaTesti() {

        // 1. Test : Testotomasyonu ana sayfaya gittiğinizi test edin

        Driver.getDriver().get("https://www.testotomasyonu.com/");

        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);

    }

    @Test(priority = 2)
    public void aramaTesti() {

        // 2. Test : search Box'ı kullanarak "phone" için arama yapın
        //           ve arama sonucunda ürün bulunabildiğini test edin

        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        bulunanUrunElementleriList = Driver.driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        Assert.assertTrue(bulunanUrunElementleriList.size() > 0);

    }

    @Test(priority = 3)
    public void ilkUrunIsimTesti() {

        // 3. Test : ilk ürünü tıklayın ve ürün isminin case sensitive olmaksızın phone içerdiğini test edin
        bulunanUrunElementleriList.get(0).click();

        WebElement urunIsimElementi = Driver.getDriver().findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedUrunIsimIcerigi = "phone";
        String actualUrunIsmiKucukHarf = urunIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualUrunIsmiKucukHarf.contains(expectedUrunIsimIcerigi));

        Driver.quitDriver();
    }

}
