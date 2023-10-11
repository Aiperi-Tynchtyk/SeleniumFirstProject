package classTests.checkBoxIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class CheckBoxIntro {
    public static void main(String[] args) throws InterruptedException {
        /*
        go to the demoqa.com/checkbox
        click on HOME checkBox
        verify "you have selected" text
        uncheck "HOME" checkbox
        verify "you have selected
         */
        WebDriver driver= Driver.getDriver();
        driver.get("https://demoqa.com/checkbox");

        WebElement homeCheckbox=driver.findElement(By.xpath("//span[@class='rct-checkbox']"));
        homeCheckbox.click();

        Thread.sleep(3000);
        boolean isCheckBoxSelected=homeCheckbox.isSelected();
        boolean isCheckBoxEnabled=homeCheckbox.isEnabled();
        boolean isDisplayed=homeCheckbox.isDisplayed();

        System.out.println("checkBox is selected? "+isCheckBoxSelected);
        System.out.println("checkBox is enabled? "+isCheckBoxEnabled);
        System.out.println("checkBox is displayed? "+isDisplayed);

        WebElement selectedText= driver.findElement(By.xpath("//span[contains(text(),'You have selected :')]"));
        System.out.println(selectedText.isDisplayed());
        homeCheckbox.click();

        Thread.sleep(3000);
        System.out.println("Is text displayed: "+selectedText.isDisplayed());









    }
    }


