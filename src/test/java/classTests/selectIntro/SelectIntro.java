package classTests.selectIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class SelectIntro {
    public static void main(String[] args) throws InterruptedException {
        /*
        go to the https://blazedemo.com/
        chose Portland as a departure city
        chose London as a destination city
        click on find flights
         */
           WebDriver driver=Driver.getDriver();
//        driver.get("https://blazedemo.com/");

//        WebElement departureCityDropDwn=driver.findElement(By.name("fromPort"));
//        Select select1=new Select(departureCityDropDwn);
//        select1.selectByVisibleText("Portland");
//
//        WebElement destinationCity=driver.findElement(By.name("toPort"));
//        Select select2=new Select(destinationCity);
//        select2.selectByVisibleText("London");
//
//        WebElement findBtn= driver.findElement(By.cssSelector("input.btn"));
//        findBtn.click();

        /*
go to the https://demoqa.com/select-menu
from old style select menu choose option black by value
from multiselect dropdown list, select "Green", "Red"
deselect "Red"
         */
        driver.get("https://demoqa.com/select-menu");
        WebElement oldStyleDropDwn=driver.findElement(By.id("oldSelectMenu"));
        Select select3=new Select(oldStyleDropDwn);
        select3.selectByValue("5");
        Thread.sleep(3000);


        WebElement multiSelectionDropDwn=driver.findElement(By.xpath("//div[contains(text(),'Select...')]"));
        multiSelectionDropDwn.click();
        String green = "Green";
        String blue="Blue";
        String black = "Black";
        String red = "Red";

        driver.findElement(By.xpath
                ("//div[contains(text(), 'Select...')]/../../../div/div/div[contains(text(), '"+ green + "')]")).click();

        driver.findElement(By.id("react-select-4-option-1"+blue)).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(), 'Blue')]/following-sibling::div")).click();







        /*
        go to the https://the-internet.herokuapp.com/dropdown
        select "option 2" by index
         */
//        WebDriver driver=Driver.getDriver();
//        driver.get("https://the-internet.herokuapp.com/dropdown");











        //driver.quit();
    }
}
