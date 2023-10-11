package classTests.webTableTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.List;

public class WebTableIntro {
    WebDriver driver;
    @Test
    public void test1(){
        driver= Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        /*
        if you get /td it will be listed of elements, and we can print them with for each
         */
        List<WebElement> firstRow=
                driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
        for (WebElement i:firstRow) {
            System.out.println(i.getText());
        }
        /*
        if you get just/tr[1] one element returned all elements in one line like a String
         */
       String list= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]")).getText();
        System.out.println(list);

       /*
       print just first names
        */

        List <WebElement> firstName = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
        for (WebElement l:firstName) {
            System.out.println(l.getText());
        }
            /*
          print header row of the table
           */
        String headLines= driver.findElement(By.xpath("//table[@id='table1']/thead/tr[1]")).getText();
        System.out.println(headLines);
    }

    @Test
    public void test2() {
        driver= Driver.getDriver();
        driver.get("https://demo.guru99.com/test/table.html");

        int index=1;
       List<WebElement> rows=driver.findElements(By.xpath("//table[@cellspacing='1']//tr"));

        for (int i = 0; i < rows.size(); i++) {

            System.out.println("Row #: "+index);

            List<WebElement>columns=driver.findElements(By.xpath("//table[@cellspacing='1']//tr["+index+"]/td"));
            for (int j = 0; j < columns.size(); j++) {

                System.out.println("\t columns "+ index + ": "+columns.get(j).getText());
            }
            index++;

        }





    }



}
