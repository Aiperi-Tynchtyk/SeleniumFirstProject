package classTests.selectIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.util.List;

public class AmazonDropDownTest {
    public static void main(String[] args) throws InterruptedException {
        /*
        go to the https://www.amazon.com/
        from
         */
        WebDriver driver= Driver.getDriver();
        driver.get("https://www.amazon.com/");

        Thread.sleep(3000);
        WebElement dropDownButton= driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropDownButton);
        select.selectByVisibleText("Electronics");

        Thread.sleep(3000);
        WebElement searchInput= driver.findElement(By.id("twotabsearchtextbox"));
        searchInput.click();
        searchInput.sendKeys("smart watch"+ Keys.ENTER);

        Thread.sleep(3000);
        List<WebElement>results=
                driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement elements: results) {
            if(!elements.getText().toLowerCase().contains("smart watch")
                    && !elements.getText().toLowerCase().contains("smartwatch")){
                System.out.println("Fail, it doesn't contain smart watch"+elements.getText());
            }
        }


    }
}
