package tests.day20_CrossBrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

import java.util.List;

public class C02_CrossBrowserUrunSepetiTesti extends TestBaseCross {

    @Test
    public void urunSepetiTesti() {

        // 1- https://www.testotomasyonu.com/ anasayfasına gidin
        driver.get(ConfigReader.getProperty("toUrl"));

        // 2- phone için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // 3- Listelenen sonuçlardan ilkini tıklayın
        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.xpath("//div[@class='product-box my-2  py-1']"));
        bulunanUrunElementleriList.get(0).click();

        // 4- urun ismini kaydedin ve sepete ekleyin
        WebElement urunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        String sayfadakiUrunIsmi = urunIsimElementi.getText();
        ReusableMethods.bekle(1);
        driver.findElement(By.xpath("//button[@class='add-to-cart']")).click();

        // 5- your cart linkine tıklayın
        driver.findElement(By.xpath("(//div[@class='cart-bar'])[2]")).click();

        // 6- kaydettiğiniz ürün ismi ile sepetteki ürün isminin
        //    case sensitive olmadan aynı olduğunu test edin

        WebElement sepettekiUrunIsimElementi = driver.findElement(By.xpath("//*[@*='product-title text-center']"));

        String sepettekiUrunIsmi = sepettekiUrunIsimElementi.getText();

        Assert.assertNotEquals(sepettekiUrunIsmi.toLowerCase(), sayfadakiUrunIsmi.toLowerCase());


    }
}
