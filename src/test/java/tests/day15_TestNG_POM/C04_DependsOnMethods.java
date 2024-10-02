package tests.day15_TestNG_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class C04_DependsOnMethods {

    /*
        Priority test method'larının çalışma sıralamasını belirler
        ancak bir önceki method çalışmadıysa veya failed olduysa
        sonraki test method'unun boşuna çalışmasına engel olmaz

        1- @Test(dependsOnMethods="a") kullandığımızda
        bağlı olan method (b), bağlı olduğu method'u (a) kontrol eder
        Eğer a method'u çalışmadıysa veya failed oldu ise b'yi ignore eder

        2- Test method'ları bağımsız olarak çalıştırılabilir
           ANCAK eğer bir method dependsOnMethods ile başka bir method'a bağlanmış ise
           direk bağlı olan method(b)'u çalıştırmak isteseniz de
           kendisi direk çalışmaz, önce bağlı olduğu method(a)' u çalıştırır
           o çalışıp PASSED olursa, kendisi(b) de çalışır

           AMA bu kural sadece iki method için geçerlidir,
           üç veya daha fazla method'un bağlı olması durumunda
           hata verir ve test method'larını çalıştıramaz


        2- İsim sırası veya priority sebebi ile
           önce bağlı olan method çalıştırmak istenirse
           bağlı olan method, önceliği bağlı olduğu method'a verir
           önce bağlı olunan method çalışır, eğer passed olursa
           bağlı olan method da çalışır

     */

    List<WebElement> bulunanUrunElementleriList;

    @Test
    public void a() {

        // 1. Test : Testotomasyonu ana sayfaya gittiğinizi test edin

        Driver.getDriver().get("https://www.testotomasyonu.com/");

        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);

    } // test otomasyon anasayfa testi

    @Test(dependsOnMethods = "a")
    public void b() {

        // 2. Test : search Box'ı kullanarak "phone" için arama yapın
        //           ve arama sonucunda ürün bulunabildiğini test edin

        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        bulunanUrunElementleriList = Driver.driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        Assert.assertTrue(bulunanUrunElementleriList.size() > 0);

    } // arama testi

    @Test(dependsOnMethods = "b")
    public void c() {

        // 3. Test : ilk ürünü tıklayın ve ürün isminin case sensitive olmaksızın phone içerdiğini test edin
        bulunanUrunElementleriList.get(0).click();

        WebElement urunIsimElementi = Driver.getDriver().findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedUrunIsimIcerigi = "phone";
        String actualUrunIsmiKucukHarf = urunIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualUrunIsmiKucukHarf.contains(expectedUrunIsimIcerigi));

        Driver.quitDriver();
    } // ilk ürün isim testi

}
