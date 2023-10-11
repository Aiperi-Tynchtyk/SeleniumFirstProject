package homeWorkTests.checkboxRadioButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class DropDownCheckBoxRadioButton {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= Driver.getDriver();
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        /*
        1. Go to http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
         */

        //2. From "Dropdown Menu(s)" select: Python, Maven, Javascript
        WebElement dropDownMenu1= driver.findElement(By.id("dropdowm-menu-1"));
        Select select=new Select(dropDownMenu1);
       Thread.sleep(3000);
        select.selectByValue("python");

        WebElement dropDownMenu2= driver.findElement(By.id("dropdowm-menu-2"));
        dropDownMenu2.click();
        Select select2=new Select(dropDownMenu2);
        select2.selectByValue("maven");

        WebElement dropDownMenu3= driver.findElement(By.id("dropdowm-menu-3"));
        dropDownMenu3.click();
        Select select3=new Select(dropDownMenu3);
        select3.selectByValue("javascript");

        //3. From "Checkboxe(s)" select all 4 checkboxes

        //Thread.sleep(3000);
        WebElement checkBox=driver.findElement(By.xpath("//input[@value='option-1']"));
        checkBox.click();
        //Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='option-2']")).click();
        //Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='option-3']")).click();

        driver.findElement(By.xpath("//input[@value='option-4']")).click();
        //Thread.sleep(5000);

        //4. From "Radio Button(s)" select Blue

        WebElement radioButton=driver.findElement(By.xpath("//input[@value='blue']"));
        radioButton.click();
        //Thread.sleep(3000);

        //5. From "Selected & Disabled" select Pumpkin
        WebElement selectButton=driver.findElement(By.cssSelector("input[value=lettuce]"));
        selectButton.click();

        //6. From "Checkboxe(s)" deselect checkbox option 1 & 2
        boolean select4 = driver.findElement(By.xpath("//input[@value='option-1']")).isSelected();
        if(select4==false){
            driver.findElement(By.xpath("//input[@value='option-1']")).click();
        }
        if(select4==true){
            driver.findElement(By.xpath("//input[@value='option-1']")).click();
        }
        System.out.println(select4);
       //Thread.sleep(3000);

        boolean select5 = driver.findElement(By.xpath("//input[@value='option-2']")).isSelected();
        if(select5==false){
            driver.findElement(By.xpath("//input[@value='option-2']")).click();
        }
        if(select5==true){
            driver.findElement(By.xpath("//input[@value='option-2']")).click();
        }
        System.out.println(select5);

//        7. From "Radio Button(s)" select Green
//        8. From "Dropdown Menu(s)" select: Java
        Thread.sleep(3000);
       driver.findElement(By.xpath("//input[@value='green']")).click();






        driver.quit();
    }
}
