package homeWorkTests.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoTest3 {
    public static void main(String[] args) throws InterruptedException {
        /*
        TASK 3:
Login to https://www.saucedemo.com/
Click on Menu on top left
Click on "About" option
Verify the URL has changed to "https://saucelabs.com/"
         */
        System.setProperty("webdriver.chrome.driver","/Users/aiperi/Desktop/projects/SeleniumProjects/src/drivers/chromedriver");

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        WebElement userName= driver.findElement(By.id("user-name"));
        userName.click();
        userName.sendKeys("standard_user");
        WebElement password=driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("about_sidebar_link")).click();

        String currentUrl=driver.getCurrentUrl();
        String expectedURL="https://saucelabs.com/";
        if(expectedURL.equals(currentUrl)){
            System.out.println("user is logged in successfully");
        }
        else {
            System.out.println("user couldn't login");
        }


        Thread.sleep(2000);
       // driver.quit();
    }
}
