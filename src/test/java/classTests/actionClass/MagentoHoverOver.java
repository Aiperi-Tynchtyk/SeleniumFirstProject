package classTests.actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.UtilWaits;
import java.util.List;
import java.util.Random;

public class MagentoHoverOver {
    public static void main(String[] args) {

        WebDriver driver = Driver.getDriver();
        driver.get("https://magento.softwaretestingboard.com/");

        UtilWaits.waitUntilElementIsClickable(driver, 10, By.id("ui-id-8")).click();
        UtilWaits.waitUntilElementIsClickable(driver, 10,
                By.xpath("//span[@class='content']/span[starts-with(text(), 'Women’s Deals')]")).click();

        WebElement chooseProduct = driver.findElement(By.xpath("//span[contains(text(),'Shop Women’s Deals')]"));
        chooseProduct.click();

        List<WebElement> productSize = UtilWaits.waitUntilAllElementAreVisible(
                driver, 20, By.xpath("//div[@class='swatch-attribute size']/div"));

        List<WebElement> productColors = UtilWaits.waitUntilAllElementAreVisible(
                driver, 20, By.xpath("//div[@class='swatch-attribute color']/div"));

        List<WebElement> addToCArtButtons = UtilWaits.waitUntilAllElementAreVisible(
                driver, 20, By.xpath("//button[@title='Add to Cart']"));


        addProductToCart(productSize, productColors, addToCArtButtons);

    }

    public static void addProductToCart
            (List<WebElement> sizes, List<WebElement> colors, List<WebElement> addToCartButtons) {

        int randomButton = new Random().nextInt(1, addToCartButtons.size());


        int randomSizeID = new Random().nextInt(1, sizes.size());
        int randomColor = new Random().nextInt(1, colors.size());

        sizes.get(randomSizeID).click();
        colors.get(randomColor).click();
        addToCartButtons.get(randomButton).click();

    }
}
