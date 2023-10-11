package classTests.iFrame;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class iFrameIntro {
    WebDriver driver;
    @Before
    public void before(){
        driver= Driver.getDriver();
        driver.get("https://www.way2automation.com/way2auto_jquery/draggable.php#load_box");
    }

    @Test
    public void test1(){
        /*
        go to the https://www.way2automation.com/way2auto_jquery/draggable.php#load_b
         */
        //switch to  iframe
        driver.switchTo().frame(0);

        WebElement draggable = driver.findElement(By.id("draggable"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(draggable).moveByOffset(200,150)
                .moveByOffset(200,200)
                .build()
                .perform();
    }
    @Test
    public void tes2() throws InterruptedException {

        driver.findElement(By.xpath("//a[contains(text(),'Constrain movement')]")).click();

        driver.switchTo().frame(1);

        WebElement draggableHorizontally = driver.findElement(By.id("draggable2"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(draggableHorizontally)
                .moveByOffset(200,0)
                .build()
                .perform();

        Thread.sleep(2000);

        actions.clickAndHold(draggableHorizontally)
                .moveByOffset(- 200,0)
                .build()
                .perform();
    }



}
