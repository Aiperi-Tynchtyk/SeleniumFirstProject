package classTests.javascriptExecutorIntro;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class JavascriptIntro {
    WebDriver driver;
    /*
    do to the https://www.eatthismuch.com/
    click on browse foods
   mo to the next page
     */

    @Test
    public void test1() throws InterruptedException {
        driver = Driver.getDriver();
        driver.get("https://www.eatthismuch.com/");
        driver.findElement(By.linkText("Browse Foods")).click();

       // mo to the next page

        WebElement arrowButton = driver.findElement(By.xpath("(//a[@class='change_page'])[2]"));
        By findArrow = By.xpath("(//a[@class='change_page'])[2]");
        String xPath = "(//a[@class='change_page'])[2]";

        //create instance of JSexecutor class
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        //click on button
        jsExecutor.executeScript("arguments[0].click();", arrowButton);
        Thread.sleep(2000);
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//a[@class='change_page'])[2]")));
        Thread.sleep(2000);
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath(xPath)));
        Thread.sleep(2000);
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(findArrow));


        Thread.sleep(2000);
        WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
        jsExecutor.executeScript("arguments[0].value='baked potato';", input);


        WebElement checkbox = driver.findElement(By.xpath("//input[@value='per_200_cal_']"));
        jsExecutor.executeScript("arguments[0].checked=true;", checkbox);

        jsExecutor.executeScript("window.scrollBy(0, 2000)");
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath(("//a[contains(text(),'Facebook')]"))));












    }
}
