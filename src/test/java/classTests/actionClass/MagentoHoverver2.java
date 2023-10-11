package classTests.actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class MagentoHoverver2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= Driver.getDriver();
        driver.get("https://magento.softwaretestingboard.com/");

        //hover over
        WebElement womenButton= driver.findElement((By.xpath("//span[contains(text(),'Women')]")));

        Actions actions=new Actions(driver);
        actions.moveToElement(womenButton);

        Thread.sleep(3000);
        WebElement tops=driver.findElement(By.id("ui-id-9"));
        actions.moveToElement(tops).perform();
        actions.click().build().perform();








        //driver.quit();

    }
}
