package utilities;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    static WebDriver driver;
    /*
        if MozilaFireFox open the geckoDriver
        if chrome open ChromeDriver
        default ChromeDriver
         */

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver","/Users/aiperi/Desktop/projects/SeleniumProjects/src/drivers/chromedriver");

        if (driver != null) {
            return driver;
        }
        String browser = Configuration.getProperty("browser");
        switch (browser) {
            case "Chrome" ->
                    driver = new ChromeDriver();
            case "firefox" ->
                    driver = new FirefoxDriver();
            default ->
                    driver = new ChromeDriver();
        }
        driver.manage().window().maximize();

        int pageWait=Integer.parseInt(Configuration.getProperty("pageLoadTimeOut"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageWait));
        /*
        page load wait until
         */

        int waitTime=Integer.parseInt(Configuration.getProperty("implicitWait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));

        return driver;
    }

    public  static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }



}
