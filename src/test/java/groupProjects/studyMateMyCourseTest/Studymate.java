package groupProjects.studyMateMyCourseTest;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

import java.util.Random;

public class Studymate {
    WebDriver driver;
    @Before
    public void before(){
        driver= Driver.getDriver();
        driver.get("https://codewiser.studymate.us/admin/analytics");
        WebElement email=driver.findElement(By.name("email"));
        email.click();
        email.sendKeys("admin@codewise.com");
        WebElement password=driver.findElement(By.name("password"));
        password.click();
        password.sendKeys("codewise123");
        WebElement login=driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        login.click();
    }

    @Test
    public void test1() throws InterruptedException {
          driver.findElement(By.xpath("//li[contains(text(),'Courses')]")).click();
        createCourse();


        //assign teacher
        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[1]/div[1]/div[3]/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[1]")).click();
//
        driver.findElement(By.xpath("//form/div/div/div")).click();
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        Actions actions=new Actions(driver);
        WebElement clickButton=driver.findElement(By.xpath("//button[text()='Save']"));
        Thread.sleep(3000);
        actions.doubleClick(clickButton).perform();
        clickButton.click();


        //delete course
          Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[1]/div[1]/div[3]/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[3]")).click();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();


    }

    public void createCourse(){

        driver.findElement(By.xpath("//button[contains(text(),'Create course')]")).click();
        WebElement courseName=driver.findElement(By.name("courseName"));
        courseName.click();
        //provide course name
        String randomString1 = generateRandomString(8);
        courseName.sendKeys(randomString1);

        //provide data of creating course
        WebElement dataOfCreateCourse=driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']"));
        dataOfCreateCourse.click();
        dataOfCreateCourse.sendKeys("06.09.2023");

        //provide description of course
        WebElement description=driver.findElement(By.xpath("//div//textarea[@name='description']"));
        description.click();
        String randomString2 = generateRandomString(20);
        description.sendKeys(randomString2);

        //crete button
        driver.findElement(By.xpath("//form[@id='courseForm']//button[contains(text(),'Create')]")).click();

    }

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

//    @Test
//    public void test (){
//        driver.findElement(By.xpath("//li[contains(text(),'Courses')]")).click();
//        String text=driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/div/div[1]")).getText();
//        System.out.println(text);
//    }










}
