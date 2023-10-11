package classTests.recap;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.util.List;
import java.util.NoSuchElementException;

public class RecapEatThisMuch {
   WebDriver driver;

    @Test
    public void test1() throws InterruptedException {
        driver= Driver.getDriver();
        driver.get("https://www.eatthismuch.com/");

        WebElement eatCcal=driver.findElement(By.id("cal_input"));
        eatCcal.click();
        eatCcal.sendKeys("2500");

        WebElement selectMeals=driver.findElement(By.id("num_meals_selector"));
        Select select=new Select(selectMeals);
        select.selectByValue("5");

        //chose mediterranean
        driver.findElement(By.xpath("//li[@data-value='mediterranean']")).click();
        //click on generate
        driver.findElement(By.xpath("//button[@data-loading-text='Generate']")).click();

        driver.findElement(By.xpath("//div[text()='No thanks']")).click();

        //verify that meals have:
        /*
        1. breakfast
        2. lunch
        3. snack
        4. dinner
        5. snack
         */

        String[] expectListOfMeal={"Breakfast","Lunch","Snack","Dinner","Snack"};
        String [] actualMeals= new String[expectListOfMeal.length];

        List<WebElement> listOfMeals= driver.findElements(By.cssSelector("div.print_meal_title"));

        for (int i = 0; i < expectListOfMeal.length; i++) {
            actualMeals[i]=listOfMeals.get(i).getText();
        }
        Assert.assertEquals("Meals didn't match",expectListOfMeal, actualMeals);

                //click on chart icon
        WebElement popUpChartIcon = driver.findElement(By.xpath("//div[@class='plan_spark_chart']"));
        Assert.assertTrue("Didn't displayed",popUpChartIcon.isDisplayed());

        popUpChartIcon.click();

        WebElement totalCaloriesWebEl = driver.findElement(By.xpath("//div[text()='Calories']//following-sibling::div"));
        int totalCall = Integer.parseInt(totalCaloriesWebEl.getText().trim());
        WebElement planCaloriesWebEl = driver.findElement(By.cssSelector("div.plan_calories"));
        int planCalories = Integer.parseInt(planCaloriesWebEl.getText().trim().split(" ")[0]);
        Assert.assertEquals(totalCall,planCalories);
        Assert.assertTrue(totalCall<Integer.parseInt("2500")+ 100);
        Assert.assertTrue(totalCall > Integer.parseInt("2500") - 100);







    }

}
