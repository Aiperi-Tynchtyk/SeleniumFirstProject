package homeWorkTests.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoHWorkTest1 {
    public static void main(String[] args) {
        /*
        Login to https://www.saucedemo.com/
Add "Sauce Labs Bolt T-Shirt" to cart
Add "Sauce Labs Fleece Jacket" to cart
Go to cart
Remove "Sauce Labs Fleece Jacket" from cart
Click on "Continue Shopping"
Add "Sauce Labs Onesie" to cart
Go to cart
Verify the price of "Sauce Labs Bolt T-Shirt" is 15.99
Click on "Checkout"
Enter following credentials:
first name: John
last name: Doe
zip code: 12345
Click on Finish
Verify "Back Home" button is displayed
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

        driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket")).click();

        driver.findElement(By.className("shopping_cart_container")).click();
        driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.id("continue-shopping")).click();

        driver.findElement(By.name("add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.className("shopping_cart_container")).click();

        String price=driver.findElement(By.className("inventory_item_price")).getText();
        String expectedPrice="$15.99";
        if(price.equals(expectedPrice)){
            System.out.println("right price");
        }
        else{
            System.out.println("wrong price");
        }

        driver.findElement(By.id("checkout")).click();

        WebElement firstName= driver.findElement(By.id("first-name"));
        firstName.click();
        firstName.sendKeys("John");

        WebElement lastName= driver.findElement(By.id("last-name"));
        lastName.click();
        lastName.sendKeys("Doe");

        WebElement zipcode=driver.findElement(By.id("postal-code"));
        zipcode.click();
        zipcode.sendKeys("12345");
       driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();

        String result=driver.findElement(By.className("complete-header")).getText();
        String expectResult="Thank you for your order!";














    }

}
