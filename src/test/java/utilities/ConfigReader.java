package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;

    static { // static blok herseyden önce çalışır

        String dosyaYolu = "configuration.properties";
        try {

            FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
            properties = new Properties();
            properties.load(fileInputStream);

        } catch (IOException e) {
            System.out.println("properties dosyasi okunamadi");
        }

    }

    public static String getProperty(String key) {

        return properties.getProperty(key);
    }

}
