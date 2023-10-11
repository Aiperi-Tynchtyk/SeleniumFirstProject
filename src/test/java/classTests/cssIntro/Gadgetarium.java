package classTests.cssIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class Gadgetarium {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=Driver.getDriver();
        driver.get("https://gadgetarium.us/");
        //implicit way
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));

        //explicit way
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(10000));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Delivery"))));


        for (int i = 1; i <=10 ; i++) {
        try{
            driver.findElement(By.linkText("Delivery")).click();
            break;
        }
        catch (ElementClickInterceptedException e){
            Thread.sleep(3000);
        }}







        String text=driver.findElement(By.xpath("//p[text()='Pay by card online']")).getText();
        System.out.println(text);





    }
}
