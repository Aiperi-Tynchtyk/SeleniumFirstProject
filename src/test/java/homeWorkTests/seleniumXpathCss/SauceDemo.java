package homeWorkTests.seleniumXpathCss;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemo {
    public static void main(String[] args) throws InterruptedException {
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
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.name("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        driver.findElement(By.name("add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.className("shopping_cart_container")).click();

        String yourCart=driver.findElement(By.xpath("//span[@class='title']")).getText();
        if(yourCart.contains("Your Cart")){
            System.out.println("contain cart");
        }
        else{
            System.out.println("doesn't contain cart");
        }
        String text2=driver.findElement(By.xpath("//div[@class='cart_desc_label']/..")).getText();
        if(text2.contains("QTY"+ "Description")){
            System.out.println("contain text2");
        }
        else{
            System.out.println("doesn't contain text2");
        }
        driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.className("shopping_cart_container")).click();
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

        String paymentInformation=driver.findElement(By.xpath("//div[@class='summary_info_label'][1]")).getText();
        if(paymentInformation.contains("Payment Information")){
            System.out.println("contain payment information");
        }
        else{
            System.out.println("doesn't contain payment information");
        }
        String shippingInformation=driver.findElement(By.xpath("//div[@class='summary_info_label'][2]")).getText();
        if(shippingInformation.contains("Shipping Information")){
            System.out.println("contain shipping information");
        }
        else{
            System.out.println("doesn't contain shipping information");
        }
        String totalInformation=driver.findElement(By.xpath("//div[@class='summary_info_label'][3]")).getText();
        if(totalInformation.contains("Price Total")){
            System.out.println("contain price information");
        }
        else{
            System.out.println("doesn't contain price information");
        }


        String price=driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']")).getText();
        String expectedPrice="Total: $86.35";
        if(price.equalsIgnoreCase(expectedPrice)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        driver.findElement(By.id("finish")).click();

        String checkoutComplete=driver.findElement(By.className("title")).getText();
        System.out.println(checkoutComplete);
        if(checkoutComplete.contains("Checkout: Complete!")){
            System.out.println("contains Checkout: Complete!");
        }
        else{
            System.out.println("doesn't contain Checkout: Complete!");
        }











        Thread.sleep(5000);
       driver.quit();
    }
}
