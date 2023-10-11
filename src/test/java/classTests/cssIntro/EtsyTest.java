package classTests.cssIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","/Users/aiperi/Desktop/projects/SeleniumProjects/src/drivers/chromedriver");

        /*
        go to the Etsy.com
        locate search input and enter "wall decor"
        click on search button
        verify "wall decor" is still in search input
        and verify URL contains "wall decor"
        click on "x" button on the search input
        remove the enter "wall decor"
         */
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.etsy.com/?ref=lgo");


        String searchWord="wall decor";
        WebElement searchInput=driver.findElement(By.name("search_query"));
        searchInput.click();
        searchInput.sendKeys(searchWord);

        WebElement searchButton=driver.findElement(By.xpath("//button[@value='Search']"));
        searchButton.click();

        String url= driver.getCurrentUrl();
        if(url.contains("wall")){
            System.out.println("it works");
        }
        else{
            System.out.println("fail");
        }

        Thread.sleep(3000);

        String value=driver.findElement(By.name("search_query")).getAttribute("value");
        if(value.equalsIgnoreCase("wall decor")){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }

        WebElement xButton= driver.findElement(By.xpath("//button[@data-search-close-btn]"));
        xButton.click();

        WebElement searchButton1=driver.findElement(By.xpath("//button[@value='Search']"));
        searchButton1.click();



        driver.quit();

    }
}
