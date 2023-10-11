package homeWorkTests.seleniumXpathCss;

import io.netty.handler.codec.compression.ZstdEncoder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/aiperi/Desktop/projects/SeleniumProjects/src/drivers/chromedriver");

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        /*
        Test case #01: Verify google search returns relevant results for a given keyword.
Steps:
1. Navigate to google.com
2. Enter "apple" in search input
3. Click on search button, or press enter
4. Verify search results contain "apple"
         */
//        Thread.sleep(3000);
//        WebElement search = driver.findElement(By.id("APjFqb"));
//        search.sendKeys("Apple"+ Keys.ENTER);
//
//        String result=driver.findElement(By.id("APjFqb")).getText();
//        if(result.equalsIgnoreCase("apple")){
//            System.out.println("verified");
//        }
//        else{
//            System.out.println("doesn't verify");
//        }
        /*
        Test case #02: Verify google search suggestions work as expected when typing in the search box.
Steps:
1. Navigate to google.com
2. Enter "how to bake" in the search box but don't press Enter.
3. Verify a dropdown appeared with auto-suggested search queries like "how to bake a cake",
"how to bake chicken", etc., based on popularity and relevance.
         */
//        Thread.sleep(3000);
//        WebElement search = driver.findElement(By.id("APjFqb"));
//        search.sendKeys("how to bake");
//        String verifyResult=driver.findElement(By.xpath("//div//span//b[text()=' salmon']/..")).getText();
//        System.out.println(verifyResult);
//        if(verifyResult.equalsIgnoreCase("how to bake salmon")){
//            System.out.println("verified");
//        }
//        else{
//            System.out.println("doesn't verify");
//        }
        


























        driver.quit();

    }
}
