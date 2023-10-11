package homeWorkTests.selectDropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import java.time.Duration;

public class Gadgetarium {
    public static void main(String[] args) throws InterruptedException {
        /*
        1. Go to https://gadgetarium.us/
2. Click on "Delivery" tab
3. Verify "Pay by card online" text is visible
4. Verify "Cash upon receipt" text is visible
5. Verify "By card upon receipt" text is visible
6. Click on "FAQ" tab
7. Verify "Frequently asked questions" text is visible
8. Click on "How can I order?"
9. Verify "You can easily order using our online platform." text is visible
10. Click on "Catalog -> Smartphones -> Apple"
11. Click on "Show more" button
         */
        WebDriver driver= Driver.getDriver();
        driver.get("https://gadgetarium.us/");
        //implicit way
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
        driver.findElement(By.xpath("//p[contains(text(),'Delivery')]")).click();

        //3. Verify "Pay by card online" text is visible
       boolean text=driver.findElement(By.xpath("//p[contains(text(),'Pay by card online')]")).isDisplayed();
       String textVerify=driver.findElement(By.xpath("//p[contains(text(),'Pay by card online')]")).getText();
        System.out.println(text);
        System.out.println(textVerify);

        //4. Verify "Cash upon receipt" text is visible
        boolean visibleTextCash=driver.findElement(By.xpath("//p[contains(text(),'Cash upon receipt')]")).isDisplayed();
        String cashText=driver.findElement(By.xpath("//p[contains(text(),'Cash upon receipt')]")).getText();
       System.out.println(visibleTextCash);
        System.out.println(cashText);

        //5. Verify "By card upon receipt" text is visible
        boolean byCartTextCash=driver.findElement(By.xpath("//p[contains(text(),'By card upon receipt')]")).isDisplayed();
        String cartText=driver.findElement(By.xpath("//p[contains(text(),'By card upon receipt')]")).getText();
        System.out.println(byCartTextCash);
        System.out.println(cartText);

        //Click on "FAQ" tab
        driver.findElement(By.xpath("//p[contains(text(),'FAQ')]")).click();
        //7. Verify "Frequently asked questions" text is visible
        boolean frequentlyTextCash=driver.findElement
                (By.xpath("//p[contains(text(),'Frequently asked questions')]")).isDisplayed();
        System.out.println(byCartTextCash);

        //8. Click on "How can I order?"
        //9. Verify "You can easily order using our online platform." text is visible
        driver.findElement(By.xpath("//span[contains(text(),'How can I order?')]")).click();
        Thread.sleep(3000);
        boolean textIsVisible=driver.findElement(By.xpath
                ("//p[contains(text(),'You can easily order using our online platform. " +
                        "When you find the product you need, you can add it to the cart, " +
                        "log in and go through the order process. After the order is ready, " +
                        "you will receive a summary of the order to your email. The order summary " +
                        "will also be stored in your account.')]")).isDisplayed();
        System.out.println(textIsVisible);

        //10. Click on "Catalog -> Smartphones -> Apple"
        //11. Click on "Show more" button

        Thread.sleep(3000);
       driver.findElement(By.cssSelector("button.css-xshx5o")).click();

        WebElement smartPhButton=driver.findElement(By.linkText("Smartphones"));
        Actions actions=new Actions(driver);
        actions.moveToElement(smartPhButton).build().perform();
        driver.findElement(By.xpath("//div/li[contains(text(),'Apple')]")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//span/button[contains(text(),'Show more')]")).click();
















        //driver.quit();

    }
}
