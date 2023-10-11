package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.sound.midi.Soundbank;

public class SeleniumUtilities {
    public WebElement findElement(WebDriver driver, By locator) {
       try{
           driver.findElement(locator);
       }
       catch (NoSuchElementException e){
           System.out.println("the element was not found "+ e.getMessage());
       }
        return null;
    }

    public WebElement findElementRetry(WebDriver driver, By locator, int numOfRetries) throws InterruptedException {
        for (int i = 1; i <=numOfRetries; i++) {
            try{
                return driver.findElement(locator);
            }catch (NoSuchElementException e){
                Thread.sleep(100);
            }
        }return  null;
    }



}
