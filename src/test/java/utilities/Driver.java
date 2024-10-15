package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
        Bu class'ın amacı belirlenen browser'a uygun webDriver objesi oluşturmak
     */

    private Driver() {
        // başka class'ların Driver class'ından obje oluşturmasını engellemek için
        // Singleton pattern kullanılmıştır
        // Singleton pattern class'dan obje oluşturulmasını engellemek için
        // constructor'ı görünür yapıp, erişimini private yapmaya dayanır
    }

    public static WebDriver driver;

    public static WebDriver getDriver() {

        String browserTercihi = ConfigReader.getProperty("browser");
        /*
            Browser'in sadece chrome olmaması için
            configuration.properties'e browser = firefox
            seçeneği ekledik.

            Orada yazan browser tercihini 20. satırda alıp
            tercihe uygun driver oluşturması için bir switch statement kullandık

         */

        if (driver == null) {

            switch (browserTercihi) {

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "egde":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;

    }

    public static void closeDriver() {

        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
