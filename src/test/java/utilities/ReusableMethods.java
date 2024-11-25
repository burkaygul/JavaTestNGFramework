package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {

    public static void wait(int sec){
        try {
            Thread.sleep(1000*sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void pageScreenshot(WebDriver driver) {

        // 1- takesScreenshot objesi olusturalim
        TakesScreenshot tss = (TakesScreenshot) driver;
        // 2- cekilen screenshot'i kaydedecegimiz dosyayi olusturalim
        String kaydedilecekDosyaYolu = "target/screenshots/tumSayfaSS.jpeg";
        // screenshot'in her calistiginda farkli isimde olmasi icin tarih damgasi ekleyelim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarihDamgasi = ldt.format(dtf); // 240402123223
        kaydedilecekDosyaYolu = "target/screenshots/tumSayfaSS"+tarihDamgasi+".jpeg";
        File tumSayfaScreenshot = new File(kaydedilecekDosyaYolu);
        // 3- tss objesini kullanarak screenshot alip, gecici bir dosyaya kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
        // 4- gecici dosyayi, asil kaydetmek istedigimiz dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
