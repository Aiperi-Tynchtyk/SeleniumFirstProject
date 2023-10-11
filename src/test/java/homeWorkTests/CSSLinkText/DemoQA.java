package homeWorkTests.CSSLinkText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class DemoQA {
    public static void main(String[] args) throws InterruptedException {
        /*
        1. Go to https://demoqa.com/text-box
        2. Enter:Full Name, Email,Current Address, Permanent Address
        3. Click on "Submit Button"
        4. Verify the details you provided appeared below the form
         */

        WebDriver driver= Driver.getDriver();
        driver.get("https://demoqa.com/text-box");
        Thread.sleep(3000);

        WebElement fullName= driver.findElement(By.cssSelector("input#userName"));
        fullName.sendKeys("Aiperi");

        WebElement email= driver.findElement(By.cssSelector("input#userEmail"));
        email.sendKeys("aiperi@gmail.com");

        WebElement currentAddress= driver.findElement(By.cssSelector("textarea#currentAddress"));
        currentAddress.sendKeys("10045 Devon avenue");

        WebElement permanentAddress= driver.findElement(By.cssSelector("textarea#permanentAddress"));
        permanentAddress.sendKeys("10045 Holy lane");

        driver.findElement(By.cssSelector("button#submit")).click();

        String verify=driver.findElement(By.cssSelector("div#output")).getText();
       if(verify.contains("Name:Aiperi\n" +
               "Email:aiperi@gmail.com\n" +
               "Current Address :10045 Devon avenue\n" +
               "Permananet Address :10045 Holy lane")){
           System.out.println("contains information");
       }
       else{
           System.out.println("doesn't contain any information");
       }







        driver.quit();

    }
}
