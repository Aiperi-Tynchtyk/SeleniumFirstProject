package classTests.allertIntro;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsHandle {
    WebDriver driver;
    String mainWindow;
    @Before
    public void before(){
        driver= Driver.getDriver();
        driver.get("https://www.letskodeit.com/");

    }
    @Test
    public void firstPage(){
        mainWindow = driver.getWindowHandle();//main window ID

        List<String> orderedWindows=new ArrayList<>();
        orderedWindows.add(mainWindow);

        WebElement practice = driver.findElement(By.linkText("PRACTICE"));
        practice.click();
        windowHandle(practice);

        String practicePage= driver.getWindowHandle();// second page
        orderedWindows.add(practicePage);

        WebElement openTabButton = driver.findElement(By.id("opentab"));
        openTabButton.click();
        windowHandle(openTabButton);


        String coursePage= driver.getWindowHandle();//third page
        orderedWindows.add(coursePage);

    }
    public void windowHandle(WebElement element){
        String handle= driver.getWindowHandle();
        Set<String> handles=driver.getWindowHandles();
        for (String i:handles) {
            if(!i.equalsIgnoreCase(handle)){
                driver.switchTo().window(i);
            }
        }
    }



}
