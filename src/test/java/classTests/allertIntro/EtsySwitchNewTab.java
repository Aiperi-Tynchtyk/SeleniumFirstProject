package classTests.allertIntro;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.Driver;

public class EtsySwitchNewTab {
    WebDriver driver;

    @Before
    public void before(){
        driver= Driver.getDriver();
        driver.get("https://www.etsy.com/");
    }
    @Test
    public void test1(){
        WebElement searchButton= driver.findElement(By.cssSelector("input[name=search_query]"));
        searchButton.sendKeys("canvas"+ Keys.ENTER);

        String url=driver.getCurrentUrl();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(url);
    }

    @Test
    public void test2(){
         /*
    go to the etsy
    go to the amazon
    go to the google
     */
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com/");

        //go to amazon
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.com/");
    }

}
