package homeWorkTests.actionTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class ActionsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/droppable");

        Actions actions = new Actions(driver);

        WebElement drugElement = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(drugElement,droppable).build().perform();


        //another element
        driver.findElement(By.id("droppableExample-tab-accept")).click();

        WebElement acceptable = driver.findElement(By.id("acceptable"));
        WebElement notAcceptable = driver.findElement(By.id("notAcceptable"));
        WebElement dropHere = driver.findElement
                (By.xpath("//div[@class='accept-drop-container']//div[@class='drop-box ui-droppable ui-state-highlight']"));

        actions.dragAndDrop(acceptable,dropHere).build().perform();
        actions.dragAndDrop(notAcceptable,dropHere).build().perform();
//
    }
}
