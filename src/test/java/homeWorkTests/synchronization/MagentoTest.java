package homeWorkTests.synchronization;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.UtilWaits;

public class MagentoTest {
    /*
    Create MagentoTest2 class, make sure to use Explicit and Fluent waits throughout the test.
    Try not to use Thread.sleep():
1. go to https://magento.softwaretestingboard.com/
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=Driver.getDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        //2. click on "What's New"
        driver.findElement(By.id("ui-id-3")).click();
        //3. click on "Jackets" in "New in men's"
        driver.findElement(By.xpath("/html/body/div[2]/main/div[4]/div[2]/div/div/ul[2]/li[2]/a")).click();

        UtilWaits.waitUntilElementIsClickable(driver,20,By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[2]/div[3]/select"));

        //4. click on "Sort by" and select by price
        WebElement selectOption = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[2]/div[3]/select"));
        Select select=new Select(selectOption);
        select.selectByValue("price");

        //5. click on "Style" and choose "Insulated"
        //6. click on "Color" and choose "Black"
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'Style')]")).click();
        driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[1]/a")).click();
//
//
        UtilWaits.waitUntilAllElementAreVisible(driver,30,By.xpath("//div[contains(text(),'Color')]"));
        driver.findElement(By.xpath("//div[contains(text(),'Color')]")).click();
        driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[3]/div[2]/div/div/a[1]/div")).click();

        //7. click on "Sale" and choose "Yes"

        UtilWaits.waitUntilElementIsClickable(driver,30,By.xpath("//*[@id=\"narrow-by-list\"]/div[8]/div[1]"));
        driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[8]/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[8]/div[2]/ol/li[1]/a")).click();

        //8. choose any color and size of the product
        driver.findElement(By.id("option-label-size-143-item-167")).click();
        driver.findElement(By.id("option-label-color-93-item-53")).click();

        //9. add to cart
       // 10. go to cart

        driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
        driver.findElement(By.xpath("//div[@data-block='minicart']//span[@class='counter qty']")).click();

//        11. proceed with checkout (provide all details: shipping, billing)

        driver.findElement(By.id("top-cart-btn-checkout")).click();

        WebElement email = driver.findElement(By.xpath("//form[@data-role='email-with-possible-login']//input[@type='email']"));
        email.sendKeys("aiperi@gmail.com");

        WebElement firstName = driver.findElement(By.xpath("//div[@class='control']//input[@name='firstname']"));
        firstName.sendKeys("Aiperi");

        WebElement lastName = driver.findElement(By.xpath("//div[@class='control']//input[@name='lastname']"));
        lastName.sendKeys("Tynchtyk");

        WebElement address = driver.findElement(By.xpath("//div[@class='control']//input[@name='street[0]']"));
        address.sendKeys("1000 Devon");

        WebElement city = driver.findElement(By.xpath("//div[@class='control']//input[@name='city']"));
        city.sendKeys("Des Plaines");

        WebElement state = driver.findElement(By.xpath("//div[@class='control']//select[@name='region_id']"));
        Select select1=new Select(state);
        select1.selectByVisibleText("Illinois");

        WebElement zipCode = driver.findElement(By.xpath("//div[@class='control']//input[@name='postcode']"));
        zipCode.sendKeys("60016");

        WebElement country = driver.findElement(By.xpath("//div[@class='control']//select[@name='country_id']"));
        Select select2=new Select(country);
        select2.selectByVisibleText("United States");

        WebElement phoneNum = driver.findElement(By.xpath("//div[@class='field _required']//input[@name='telephone']"));
        phoneNum.sendKeys("12345");

       // 12. choose "Fixed" shipping method
//        13. click on "Place order"
//        14. verify "Thank you for your purchase!" text is there

        WebElement chooseFixed=driver.findElement(By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[2]/td[1]/input"));
        chooseFixed.click();
        driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Place Order')]")).click();

        String verify=driver.findElement(By.xpath("//span[contains(text(),'Thank you for your purchase!')]")).getText();
        if(verify.contains("Thank you for your purchase!")){
            System.out.println("pass");
        }
        else{
            System.out.println("fail");
        }






        driver.quit();






    }
}
