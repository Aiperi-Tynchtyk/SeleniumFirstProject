package homeWorkTests.actionTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;
import java.util.List;

public class MagentoActionTest {
    WebDriver driver;
    /*
    1. go to https://magento.softwaretestingboard.com/
     */
    @Before
    public void before(){
        driver= Driver.getDriver();
        driver.get("https://magento.softwaretestingboard.com/");
    }
    @Test
    public void test1() throws InterruptedException {
//        2. hover over "Men"
//        3. hover over "Tops"
//        4. click on "Tees"
        WebElement menButton= driver.findElement((By.xpath("//span[contains(text(),'Men')]")));

        Actions actions=new Actions(driver);
        actions.moveToElement(menButton);

        Thread.sleep(3000);
        WebElement tops=driver.findElement(By.id("ui-id-17"));
        actions.moveToElement(tops);
        Thread.sleep(3000);
        actions.click().build().perform();
        driver.findElement(By.id("ui-id-21")).click();
    }

    @Test
    public void test2(){
//        5. locate search field and search for "Jacket"
//        6. verify all 12 product names on page contain "Jacket"
        WebElement search = driver.findElement(By.id("search"));
        search.sendKeys("Jacket"+ Keys.ENTER);

        List<WebElement> elementList=driver.findElements(By.cssSelector("div[class='products wrapper grid products-grid']"));
        int counter=0;
        for (int i = 0; i < elementList.size(); i++) {
            if(elementList.get(i).getText().contains("Jacket")){
                counter++;
            }
            if(counter==elementList.size()){
                System.out.println("They are all contains jacket");
            }}
    }

    @After
    public void close(){
        Driver.closeDriver();
    }


}
