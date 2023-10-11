package classTests.synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;
import utilities.UtilWaits;

import java.util.List;
import java.util.Random;

public class MagentoTest {
    public static void main(String[] args) {
        /*
        go to the https://magento.softwaretestingboard.com/
        click on sale
        click on women's deals
        choose size, color for the first product and add to the cart
        click on add to cart for the second product
        choose size, color and quantity and add to the cart
        go to cart
8.      click on "Proceed to Checkout"
9.      checkout
         */
        WebDriver driver= Driver.getDriver();
        driver.get("https://magento.softwaretestingboard.com/");

        UtilWaits.waitUntilElementIsClickable(driver,10,By.id("ui-id-8")).click();
        UtilWaits.waitUntilElementIsClickable(driver,10,
                By.xpath("//span[@class='content']/span[starts-with(text(), 'Women’s Deals')]")).click();

        //select what item you want to add to cart
        Random random = new Random();
        int itemChoice = random.nextInt(1,13);

        Actions actions = new Actions(driver);


        List<WebElement> product = UtilWaits.waitUntilAllElementAreVisible
                (driver, 20, By.xpath("(//ol[@class='products list items product-items']//li)" ));

        actions.moveToElement(product.get(itemChoice)).build().perform();

        int itemSize = random.nextInt(1,6);
        WebElement size = driver.findElement
                (By.xpath("(//div[@class='swatch-option text'])[" + itemSize + "]"));
        size.click();

        int itemColor = random.nextInt(1,4);
        WebElement color = driver.findElement
                (By.xpath("(//div[@class='swatch-option color'])[" + itemColor + "]"));
        color.click();


        driver.findElement
                (By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[4]/div/div[1]/form/button/span")).click();

        driver.quit();

    }
}
