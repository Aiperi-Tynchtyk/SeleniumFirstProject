package classTests.iFrame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.Set;

public class PracticeiFrameWindows {
    /*
    go to the
    click on new browser tab link
    switch to the new tab, verify its title, close this page
    come back to the main page
    click on Open new window
    switch to new tab, verify its title, close this page
    come back to the main window
     */
    WebDriver driver;
    @Before
    public void before(){
        driver= Driver.getDriver();
        driver.get("https://www.way2automation.com/way2auto_jquery/frames-and-windows.php#load_box");
    }
    @Test
            public void testTabs() {

        String mainPageHandle = driver.getWindowHandle();


        WebElement newWindow1 = driver.findElement(By.xpath("//a[contains(text(), 'Open New Window')]"));
        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@src='frames-windows/defult1.html']"));

        checkNewWindow(driver, newWindow1, iframe1, By.xpath("//a[text()='New Browser Tab']"),
                "jQuery UI Datepicker - Default functionality", mainPageHandle);



        WebElement newWindow2 = driver.findElement(By.xpath("//a[contains(text(), 'Open Seprate New Window')]"));
        WebElement iframe2 = driver.findElement(By.xpath("//iframe[@src='frames-windows/defult2.html']"));

        checkNewWindow(driver, newWindow2, iframe2, By.xpath("//a[text()='Open New Seprate Window']"),
                "Open New Seprate Window", mainPageHandle);
    }

   public void checkNewWindow(WebDriver driver, WebElement newWindow, WebElement iframe, By linkToClick, String title, String mainPageHandle){
        /*
        1. click on window
        2. switch to new frame
        3. click on link
        4. switch to new window/page
        5. verify its title
        6. close the new page
        7. switch to main window
         */
        newWindow.click();
        driver.switchTo().frame(iframe);
        driver.findElement(linkToClick).click();
        switchToNewWindow(driver, mainPageHandle);
        Assert.assertEquals(title, driver.getTitle());
        driver.close();
        driver.switchTo().window(mainPageHandle);
        }

public void switchToNewWindow(WebDriver driver, String mainPageID){
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows){
        if (!window.equals(mainPageID)){
        driver.switchTo().window(window);
        }
        }
        }




}
