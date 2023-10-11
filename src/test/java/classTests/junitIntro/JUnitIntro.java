package classTests.junitIntro;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

public class JUnitIntro {
    @Test
    public void test1(){
        WebDriver driver= Driver.getDriver();
        driver.get("https://www.google.com/");

        String actualTittle=driver.getTitle();
        String expectedTitle="Google";

        if(actualTittle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Pass");
        }
        else{
            System.out.println("Fail");
        }


    }
    @Test @Ignore //it doesn't run just skip
    public void test2(){
        System.out.println("it is second test!");
    }

    @Test
    public void test3(){
        System.out.println("it is 3 test!");
        Assert.assertNotEquals(123,1234);
        Assert.assertTrue(3+3==6);
    }
    @Before
    public void beforeTestMethod(){
        System.out.println("this test is run before every test");
    }
    @After
    public void afterTest(){
        System.out.println("This method runs after every test");
    }
    @BeforeClass
    public static void beforeClass(){
        System.out.println("This methos is before class");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("This method is after class");
    }




}
