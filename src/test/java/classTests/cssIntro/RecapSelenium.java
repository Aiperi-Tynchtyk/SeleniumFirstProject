package classTests.cssIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RecapSelenium {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/aiperi/Desktop/projects/SeleniumProjects/src/drivers/chromedriver");

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
      //  Thread.sleep(5000);
        WebElement inputBar = driver.findElement(By.name("q"));
        inputBar.sendKeys("Codewise Academy"+Keys.ENTER);//second way to put enter button
       // inputBar.sendKeys(Keys.ENTER);

        Thread.sleep(3000);// if code doesn't work
        WebElement searchButton = driver.findElement(By.name("btnK"));
        System.out.println(searchButton.getText());
        searchButton.click();



        Thread.sleep(3000);
       // driver.quit();

    }

}
