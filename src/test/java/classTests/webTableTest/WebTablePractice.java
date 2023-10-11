package classTests.webTableTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.List;

public class WebTablePractice {
    WebDriver driver;
    @Test
    public void test1(){
        /*
        print the all information whose age less or equal to 25
         */
        driver= Driver.getDriver();
        driver.get("https://omayo.blogspot.com/");

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for (int i = 0; i<rows.size(); i++) {
            List<WebElement> ages = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td[2]"));
                    List<WebElement> names = driver.findElements(By.xpath("//table[@id=‘table1’]/tbody/tr[" + (i + 1) + "]/td[1]"));
                            List<WebElement> places = driver.findElements(By.xpath("//table[@id=‘table1’]/tbody/tr[" + (i + 1) + "]/td[3]"));
            for (int j = 0; j < ages.size(); j++) {
                int agesInt = Integer.parseInt(ages.get(j).getText());
                if (agesInt <= 25){
                    System.out.println("Name: " + names.get(j).getText());
                    System.out.println("Age: " + ages.get(j).getText());
                    System.out.println("Place: " + places.get(j).getText());
                    System.out.println();
                }
            }
        }
    }
    @Test
    public void test2(){
        driver= Driver.getDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        for(int i = 1; i <= 7; i++){
            String xpath = "//table[@id='customers']//tr[" + i + "]//*";
            List<WebElement> tDetails = driver.findElements(By.xpath(xpath));
            for(WebElement j: tDetails){
                System.out.print(j.getText() + " ");
            }
            System.out.println();
        }
        


    }


}
