package classTests.seleniumExceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.List;

public class EatThisMuchExceptionHandling {
    /*
     /*
    go to the https://www.eatthismuch.com/
TASK #1
1. go to https://www.eatthismuch.com/
2. click on "Browse Foods"
3. create 6 Lists of:
	- Title
	- Calories
	- Carbs
	- Fat
	- Protein
	- Sugar
4. verify the sizes of lists are equal
------------------------------------------
TASK #2
1. Create Products class with variables:
	- Title
	- Calories
	- Carbs
	- Fat
	- Protein
	- Sugar
2. Create getters and setters for every variable
3. Create ProductsTest class
4. go to https://www.eatthismuch.com/
5. click on "Browse Foods"
6. create List<Products>
7. inside the list, store products with calories:
	between 100 and 200 inclusively.
	Every object inside the list must have values for all variables:
			- Title
			- Calories
			- Carbs
			- Fat
			- Protein
			- Sugar
     */

    WebDriver driver;
    @Test
    public void test1(){
        driver = Driver.getDriver();
        driver.get("https://www.eatthismuch.com/");

        try {
            driver.findElement(By.linkText("Browse\n" +
                    "                                    Foods")).click();
        }
        catch (NoSuchElementException e){
            driver.findElement(By.linkText("Browse Foods")).click();
        }

        List<WebElement> titles=driver.findElements(By.cssSelector("div.result_name"));
        System.out.println(titles.size());

        List <WebElement> calories=driver.findElements(By.xpath("//div[@class='col-2 offset-1 nutrient_cell']"));
        System.out.println(calories.size());








    }
}
