package classTests.allertIntro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;
import utilities.Driver;

public class BrowserPopUp {
    WebDriver driver;
    @Before
    public void prepareDriver(){
        System.setProperty
                ("webdriver.chrome.driver","/Users/aiperi/Desktop/projects/SeleniumProjects/src/drivers/chromedriver");
    }

    @Test
    public void testWithoutDisable(){
    driver=new ChromeDriver();
    driver.get("https://ultimateqa.com/");
    }

    @Test
    public void testDisable(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        driver=new ChromeDriver(options);
        driver.get("https://ultimateqa.com/");

    }
    @After
    public void close(){
        Driver.closeDriver();
    }
}
