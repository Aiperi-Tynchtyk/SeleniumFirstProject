package homeWorkTests.selectDropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.time.Duration;

public class BlogSpot {
    public static void main(String[] args) {
        /*
        1. Go to https://omayo.blogspot.com/
2. From "Older Newslette" dropdown select option: doc 3
3. In "Text Area Field", enter hello
         */

        WebDriver driver= Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));

        driver.get("https://omayo.blogspot.com/");
        WebElement oldNewslDropDwn=driver.findElement(By.id("drop1"));
        Select select=new Select(oldNewslDropDwn);
        select.selectByValue("jkl");

        WebElement textField=driver.findElement(By.id("ta1"));
        textField.sendKeys("Hello");





        //driver.quit();

    }
}
