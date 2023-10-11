package classTests.downloadUpload;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class DownloadUpload {
    WebDriver driver;

    @Test
    public void test1Download() {
        driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/download");
// download screnshot.png
        driver.findElement(By.linkText("scrrenshot.png")).click();

        driver.findElement(By.linkText("Write Excel Testdata1.xlsx")).click();
    }

    @Test
    public void test2Upload() {
        driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/upload");

        // locate to the upload button
        WebElement fileUploadButton = driver.findElement(By.id("file-upload"));

        // find the absolute xpath to file as send it as keys
        fileUploadButton.sendKeys("/Users/aiperi/Desktop/codewise HW/Automation/Selenium.pages");

        driver.findElement(By.id("file-submit")).click();
    }

    @Test
    public void test3Upload() {
        driver = Driver.getDriver();
        driver.get("https://demo.guru99.com/test/upload/");

        WebElement fileUploadButton = driver.findElement(By.name("uploadfile_0"));

        fileUploadButton.sendKeys("/Users/aiperi/Desktop/codewise HW/Photoes/covene-BtHRjAiNDR4-unsplash.jpg");
        driver.findElement(By.xpath("//button[text()='Submit File']")).click();



    }
}