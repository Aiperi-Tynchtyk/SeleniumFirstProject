package classTests.allertIntro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

public class LambdaTest {
    WebDriver driver;
        /*
        TC #1
        go to the https://www.lambdatest.com/selenium-playground/bootstrap-modal-demo
        click on launch modal
        click save changes

        TC #2
        click on launch modal
        click on close

        TC#3
         click on launch modal
        click on X button
         */
    @Before
    public void before(){
       // go to the https://www.lambdatest.com/selenium-playground/bootstrap-modal-demo
        driver=Driver.getDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-modal-demo");
    }
    @Test
        public void safeChanges(){
//            click on launch modal
//            click save changes
           driver.findElement(By.xpath("//div[text()='Single Modal']//following-sibling::button")).click();
           driver.findElement(By.xpath("//div[@id='myModal']//button[text()='Save Changes']")).click();
        }

    @Test
    public void closePopUp() throws InterruptedException {
//            click on launch modal
//            click on close
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Single Modal']//following-sibling::button")).click();
        driver.findElement(By.xpath("//div[@id='myModal']//button[text()='Close']")).click();

    }
    @Test
    public void clickOnXButton(){
//            click on launch modal
//            click on X button
        driver.findElement(By.xpath("//div[text()='Single Modal']//following-sibling::button")).click();
        driver.findElement(By.xpath("//div[@id='myModal']//button[text()='×']")).click();
    }
    @After
    public void close(){
        Driver.closeDriver();
        System.out.println("close window");
    }

}
