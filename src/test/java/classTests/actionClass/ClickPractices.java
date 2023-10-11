package classTests.actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class ClickPractices {
    public static void main(String[] args) throws InterruptedException {
        /*
        go to the https://demo.guru99.com/test/simple_context_menu.html
        click on right click button
        thread.sleep
        right click on button
        click on double click button
        thread.sleep
        double click on double click button
         */
        WebDriver driver= Driver.getDriver();

        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement rightClick=
        driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));

        Actions actions=new Actions(driver);
        WebElement doubleClickButton=
                driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me To See Alert')]"));

        Thread.sleep(3000);
        actions.contextClick(rightClick).perform();

        actions.contextClick(doubleClickButton).perform();
        Thread.sleep(3000);



    }
}
