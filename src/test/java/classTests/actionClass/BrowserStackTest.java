package classTests.actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class BrowserStackTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= Driver.getDriver();
        driver.get("http://www.browserstack.com/");

        //driver.findElement(By.id("signupModalButton")).click(); -> first way
//        Thread.sleep(3000);
//        Actions actions=new Actions(driver);
//        actions.moveToElement(driver.findElement(By.id("signupModalButton"))).click().perform();




        //driver.quit();
    }
}
