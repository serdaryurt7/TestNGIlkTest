package tests.day15_TestNG_POM;

import org.testng.annotations.Test;

public class C03_PriorityKurallari {

    /*
        1- eğer bizim müdahalemiz olmazsa TestNG testleri isim sırasına göre çalıştırır
        2- Eğer biz testleri sıralamak istersek
           (priority = istenenDeger) yazarız
           ve TestNG priority değerlerine bakarak küçükten büyüğe doğru çalıştırır
        3- Bazı test method'larına priority ataması yapıp, bazılarına yapmazsak
           TestNG atama yapılmayanlara default olarak priority = 0 atamasını yapar
           ve bu değere göre priority'leri sıralar
        4- Eğer aynı priority değerine sahip birden fazla test method'u varsa
           kendi içlerinde harf sırasına göre çalışırlar
     */


    @Test(priority = -10)
    public void testOtomasyonTesti() {

        System.out.println("test otomasyonu testi calisti");

    }

    @Test
    public void WiseQuarterTesti() {

        System.out.println("Wise Quarter testi calisti");

    }

    @Test
    public void YoutubeTesti() {

        System.out.println("Youtube testi calisti");

    }


}
