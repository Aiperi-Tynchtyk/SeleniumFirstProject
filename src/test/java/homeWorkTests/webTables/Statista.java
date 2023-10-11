package homeWorkTests.webTables;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;
import utilities.UtilWaits;

public class Statista {
    /*
    Create StatistaTest class
1. go to https://www.statista.com/



5. select "Asia" from regions/countries filter
6. select "Agriculture" from industry filter
7. select "English" from language filter
8. select "Statistics" from report type filter
9. in results, verify "Wilmar International" report is present
10. verify the price is 495$
11. verify that it was published on "November 2022"
     */
    WebDriver driver;

    @Test
    public void test1() throws InterruptedException {

        driver= Driver.getDriver();
        driver.get("https://www.statista.com/");

       // 2. click on "Accept all" in pop up
        Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();

        System.out.println(alert.getText());
        alert.accept();
//        UtilWaits.waitUntilElementIsClickable(driver,10,By.xpath("//div[@class='ot-pc-footer']//button[text()='Accept all']"));
//        driver.findElement(By.xpath("//div[@class='ot-pc-footer']//button[text()='Accept all']")).click();

        // 3. hover over "Reports" tab on menu bar on top
        // 4. click on "Companies & Products reports"
        WebElement reportsButton= driver.findElement((By.id("navReports")));

        Actions actions=new Actions(driver);
        actions.moveToElement(reportsButton);

        Thread.sleep(3000);
        WebElement clickOnComp=driver.findElement(By.xpath("//p[text()='Companies & Products reports']"));
        actions.moveToElement(clickOnComp).perform();
        actions.click().build().perform();



    }

}
