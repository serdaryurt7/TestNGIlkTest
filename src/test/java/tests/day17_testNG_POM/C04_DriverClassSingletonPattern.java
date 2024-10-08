package tests.day17_testNG_POM;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_DriverClassSingletonPattern {

    @Test
    public void test01() {

        /*
            Testlerimizde kullanacağımız WebDriver objesini
            utilities/ Driver class'ındaki getDriver() ile oluşturuyoruz

            Driver'ın class'ındaki WebDriver objesi olarak oluşturulan
            driver'a, Driver Class'ından obje oluşturarak da erişebiliriz
            Ancak mahşerin 4 atlısı çalışmadığından
            driver objesi bir işe yaramaz

            POM dizaynında Driver class'ındaki driver objesine
            obje üzerinden erişimi iptal etmek için singleton pattern tercih edilmiş
         */

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // Driver obj = new Driver();
        // obj.driver.get(ConfigReader.getProperty("toUrl"));

    }

}
