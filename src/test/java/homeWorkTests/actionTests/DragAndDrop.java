package homeWorkTests.actionTests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class DragAndDrop {
    /*
    1. go to https://www.way2automation.com/way2auto_jquery/droppable.php#load_box
2. drag and drop white square into gray square
3. go to https://www.way2automation.com/way2auto_jquery/draggable.php#load_box
4. play around with square, drag it without dropping
5. go to https://demoqa.com/droppable
6. drag and drop the square
     */
    WebDriver driver;

    @Before
    public void before() {
        driver = Driver.getDriver();
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
    }
     @Test
    public void test1(){
//         Actions actions=new Actions(driver);
//         WebElement drugElement = driver.findElement(By.id("draggable"));
//         WebElement droppable = driver.findElement(By.id("droppable"));
//
//         actions.dragAndDrop(drugElement,droppable).build().perform();


     }








}
