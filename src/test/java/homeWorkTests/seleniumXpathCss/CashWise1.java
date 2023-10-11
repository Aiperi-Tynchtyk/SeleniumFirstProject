package homeWorkTests.seleniumXpathCss;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CashWise1 {
    public static void main(String[] args) throws InterruptedException {
        //task#1
        // 1. Go to https://cashwise.us/main

        System.setProperty("webdriver.chrome.driver","/Users/aiperi/Desktop/projects/SeleniumProjects/src/drivers/chromedriver");

        WebDriver driver=new ChromeDriver();
        driver.get("https://cashwise.us/main");

        //2. Verify URL contains "cashwise"
        String actualURL=driver.getCurrentUrl();
        if(actualURL.contains("cashwise")){
            System.out.println("URL contains CashWise");
        }
        else{
            System.out.println("URL doesn't contains CashWise");
        }
        Thread.sleep(1000);

        //3. Verify "accounting@gmail.com" is present on top left
        String accountVerify=driver.findElement(new By.ByXPath("//div[@class='css-1270swg']//child::p[text()='accounting@gmail.com']")).getText();
        if(accountVerify.contains("accounting@gmail.com")){
            System.out.println("Account contain Gmail");
        }
        else{
            System.out.println("Account doesn't contain Gmail");
        }

        //4. Verify "sign in" button is present
        String signIn=driver.findElement(By.xpath("//button[text()='Sign in']")).getText();
        System.out.println(signIn);
        if(signIn.contains("Sign in")){
            System.out.println("Sign in");
        }
        else{
            System.out.println("Not found sign in");
        }
        //5. Verify "sign up" button is present

        String signUp=driver.findElement(By.xpath("//button[@type='button'][2]")).getText();
        if(signUp.contains("SIGN UP")){
            System.out.println("Sign up");
        }
        else{
            System.out.println("Not found sign up");
        }

        /*
        Test Case 2:
1. Go to https://cashwise.us/main
         */
        Thread.sleep(3000);
        //2. Click on "sign up" button
        //3. Provide any email
       driver.findElement(By.xpath("//button[@type='button'][2]")).click();
        WebElement eMail=driver.findElement(By.xpath("//input[@id=':r3:']"));
        eMail.sendKeys("aiperi@mail.ru");

        Thread.sleep(3000);
        //4. Provide 4 chars password
        //5. Verify "Password must be at least 6 characters" message pops up
        WebElement password=driver.findElement(By.xpath("//input[@id=':r4:']"));
        password.sendKeys("1234");

        Thread.sleep(3000);
        WebElement confirmPassword=driver.findElement(By.xpath("//input[@id=':r5:']"));
        confirmPassword.sendKeys("1234");

        driver.findElement(By.xpath("//button[text()='Continue']")).click();

        String verifyPassword=driver.findElement(By.xpath("//p[text()='Password must be at least 6 characters']")).getText();
        if(verifyPassword.equalsIgnoreCase("Password must be at least 6 characters")){
            System.out.println("password verified");
        }
        else{
            System.out.println("password doesn't verified");
        }








        //driver.quit();
    }
}
