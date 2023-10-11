package classTests.allertIntro;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.UtilWaits;

import java.time.Duration;
import java.util.Set;

public class SauceDemoNewWindow {
    WebDriver driver;
    String sauceLabMainWindow;
    @Before
    public void before(){
        driver=Driver.getDriver();
        driver.get("https://www.saucedemo.com");
        WebElement username=driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");
        WebElement password=driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("secret_sauce");
        WebElement login=driver.findElement(By.id("login-button"));
        login.click();
    }
    @Test
    public void testSocialMediaTwitter(){
        /*
        click on Twitter icon
         */
        sauceLabMainWindow = driver.getWindowHandle();
        UtilWaits.waitUntilElementIsClickable(driver, 20, By.linkText("Twitter"));
         /*
        verify Twitter URL match with my expected URL
         */
        WebElement twitter = driver.findElement(By.linkText("Twitter"));
        verifySocialMediaURL(twitter,"https://twitter.com/saucelabs",sauceLabMainWindow);
    }
    @Test
    public void testSocialMediaFaceBook(){
        /*
        click on Facebook icon
         */
        sauceLabMainWindow = driver.getWindowHandle();
        UtilWaits.waitUntilElementIsClickable(driver, 5, By.linkText("Facebook"));

        //verify facebook URL
        WebElement facebook = driver.findElement(By.linkText("Facebook"));
        verifySocialMediaURL(facebook,"https://www.facebook.com/saucelabs",sauceLabMainWindow);

    }

    @Test
    public void testSocialMediaLinkedin(){
        /*
        click on LinkedIn icon
         */
        sauceLabMainWindow = driver.getWindowHandle();
        UtilWaits.waitUntilElementIsClickable(driver, 20, By.linkText("LinkedIn"));

        WebElement linkedIn = driver.findElement(By.linkText("LinkedIn"));
        verifySocialMediaURL(linkedIn,"https://www.linkedin.com/company/sauce-labs/",sauceLabMainWindow);


    }

    public void verifySocialMediaURL(WebElement socialMediaButton, String expectedURL,
                                     String mainPageID){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(socialMediaButton));
        socialMediaButton.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
       for(String window: driver.getWindowHandles()){
           if(!window.equalsIgnoreCase(mainPageID)){
               driver.switchTo().window(window);
           }
       }
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
       driver.close();
       driver.switchTo().window(mainPageID);

    }

    @After
    public void closeWindows(){

    }

}
