package classTests.cssIntro;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Driver;

public class SauceDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/aiperi/Desktop/projects/SeleniumProjects/src/drivers/chromedriver");

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();//maximize  the screen
//        driver.manage().window().minimize();
//        driver.manage().window().fullscreen();

        //System.out.println(driver.findElement(By.tagName("form")).getText());

//        WebElement username=driver.findElement(By.id("user-name"));
//        username.click();
//        username.sendKeys("standard_user");
//        WebElement password=driver.findElement(By.id("password"));
//        password.click();
//        password.sendKeys("secret_sauce");
//        WebElement login=driver.findElement(By.id("login-button"));
//        login.click();
//        /*
//        Test Case1:
//        first go to saucedemo.com
//        provide valid username
//        Provide valid password
//        Click on login button
//        Verify user is logged in
//         */
        String expectedURL="https://www.saucedemo.com/inventory.html";
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals("did not match",expectedURL,actualURL);
//
//        /*
//        TC#2:
//        Go to saucedemo.com
//        Provide valid user name
//        Provide valid password
//        Click on login demo
//        Verify user is  logged in
//        Add sauceLab backpack to the cart
//        Go to the cart
//        Click on checkout button
//        Enter first name
//        Enter Last name
//        Enter zip code
//        CLick on continue
//        CLick on finish
//        Verify checkout is success
//         */
//
//       driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();//add to cart backpack
//        WebElement shoppingCart=driver.findElement(By.className("shopping_cart_container"));
//        shoppingCart.click();
//        WebElement checkoutButton=driver.findElement(By.id("checkout"));
//        checkoutButton.click();
////
////        /*
////        locate last name, first name, zip code
////        fill out with data
////        click on continue
////         */
////
//        WebElement firstName=driver.findElement(By.id("first-name"));
//        firstName.click();
//        firstName.sendKeys("Aiperi");
//        WebElement lastName=driver.findElement(By.id("last-name"));
//        lastName.click();
//        lastName.sendKeys("TY");
//        WebElement zipCOde= driver.findElement(By.id("postal-code"));
//        zipCOde.click();
//        zipCOde.sendKeys("60016");
//
//        driver.findElement(By.id("continue")).click();
//        driver.findElement(By.id("finish")).click();
//
//        String result=driver.findElement(By.className("complete-header")).getText();
//        String expectResult="Thank you for your order!";





//        WebElement backHomeButton=driver.findElement(By.id("back-to-products"));
//        String text=backHomeButton.getText();












driver.quit();

    }




}
