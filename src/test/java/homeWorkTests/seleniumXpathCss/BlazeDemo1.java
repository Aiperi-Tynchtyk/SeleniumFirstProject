package homeWorkTests.seleniumXpathCss;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BlazeDemo1 {
    public static void main(String[] args) throws InterruptedException {
        /*
        TASK
1. Go to https://blazedemo.com
2. Verify that the destination of the week is Hawaii.
Pseudo code
1. Create a class and main method
2. Create driver object from Chrome
3. Go to given website
4. Maximize the window
5. Locate the link (destination of the week! The Beach!)
6. Click on that web element
7. Locate the text of the picture
8. Use String manipulation to read the destination part of that text
9. Verify if it is "Hawaii"
         */

        System.setProperty("webdriver.chrome.driver", "/Users/aiperi/Desktop/projects/SeleniumProjects/src/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://blazedemo.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//p/a[@href='vacation.html']")).click();

        String text=driver.findElement(By.xpath("//img/..")).getText();
        if(text.contains("Hawaii")){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
        Thread.sleep(2000);
        driver.quit();





    }
}
