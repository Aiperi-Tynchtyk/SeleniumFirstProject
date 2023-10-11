package homeWorkTests.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoTest2 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Go to https://www.saucedemo.com/
To login, enter
username: locked_out_user
password: secret_sauce
Verify user was not able to login by checking if this message appears
"Epic sadface: Username and password do not match any user in this service"
         */
        System.setProperty("webdriver.chrome.driver","/Users/aiperi/Desktop/projects/SeleniumProjects/src/drivers/chromedriver");

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        WebElement userName= driver.findElement(By.id("user-name"));
        userName.click();
        userName.sendKeys("locked_out_user");
        WebElement password=driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String error= driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        String expectedResult = "Epic sadface: Sorry, this user has been locked out.";
        if(error.equals(expectedResult)){
            System.out.println("Verified");
        }
        else{
            System.out.println("Not verified");
        }





        //Thread.sleep(3000);
        driver.quit();
    }
}
