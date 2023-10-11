package classTests.allertIntro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

public class AlertDemo99 {

    WebDriver driver;
    @Before
    public  void initializeDriver() throws InterruptedException {
        driver= Driver.getDriver();
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.cssSelector("input[name=cusid")).sendKeys("1234");
        driver.findElement(By.cssSelector("input[name=submit")).click();

        Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();
    }

    @Test
    public  void testAlert1() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.cssSelector("input[name=cusid")).sendKeys("1234");
        driver.findElement(By.cssSelector("input[name=submit")).click();

        Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();

        System.out.println(alert.getText());
        alert.accept();// accepts first alert


        Thread.sleep(3000);
        System.out.println(alert.getText());
        alert.accept();// accept second alert
    }
    @Test
    public void testAlert2() throws InterruptedException {
       /*provide ID
       click on delete
        press on cancel ->alert dismiss
        */
        Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();// accepts first alert
    }

    @After
    public void driverQuit(){
        driver.quit();
    }



}
