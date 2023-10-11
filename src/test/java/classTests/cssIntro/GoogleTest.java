package classTests.cssIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/aiperi/Desktop/projects/SeleniumProjects/src/drivers/chromedriver");
        System.out.println("Hello automation!");

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());







    }

}
