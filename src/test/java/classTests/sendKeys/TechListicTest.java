package classTests.sendKeys;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class TechListicTest {
    public static void main(String[] args) {
        WebDriver driver= Driver.getDriver();
        driver.get("https://cashwise.us/main");

        /* go to the https://www.techlistic.com/p/selenium-practice-form.html
        send your name to first name field
        ctrl+c the entered name
        paste it in last name field
         */

        driver.findElement
                (By.xpath("//button[@class='MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root css-1o6c4rv']")).click();

        WebElement email = driver.findElement(By.cssSelector("input[id=':r3:']"));
        WebElement password = driver.findElement(By.cssSelector("input[id=':r4:']"));

        email.click();
        email.sendKeys("Aiperi");

        Actions actions = new Actions(driver);

        actions.moveToElement(email)
                .click()
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .keyUp(Keys.COMMAND)
                .build()
                .perform();

        actions.moveToElement(email)
                .keyDown(Keys.COMMAND)
                .sendKeys("c")
                .keyUp(Keys.COMMAND)
                .build()
                .perform();

        actions.moveToElement(password)
                .click()
                .keyDown(Keys.COMMAND)
                .sendKeys("v")
                .keyUp(Keys.COMMAND)
                .build()
                .perform();





    }
}
