package homeWorkTests.CSSLinkText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

import java.time.Duration;

public class DemoQALinkText {
    public static void main(String[] args) throws InterruptedException {
        /*
        1. Go to https://demoqa.com/links
2. Click on "Home" link and "Homesk97a"
3. Click on "Created" link
4. Verify following text appeared: "Link has responded with staus 201 and status text Created"
5. Click on "No Content" link
6. Verify following text appeared: "Link has responded with staus 204 and status text No Content"
7. Repeat the same verifications with other links as well:
Moved
Bad Request
Unauthorized
Forbidden
Not Found
         */
        WebDriver driver= Driver.getDriver();
        driver.get("https://demoqa.com/links");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));

        driver.findElement(By.linkText("Home")).click();
       driver.findElement(By.id("dynamicLink")).click();
       driver.findElement(By.linkText("Created")).click();


        //Created
       String createdLink=driver.findElement(By.id("linkResponse")).getText();
        if(createdLink.equalsIgnoreCase("Link has responded with staus 201 and status text Created")){
           System.out.println("Created link is verified");
       }
       else{
           System.out.println("created link doesn't verified");
       }

        //TNo content
       driver.findElement(By.linkText("No Content")).click();
        String noContentLink=driver.findElement(By.id("linkResponse")).getText();

        if(noContentLink.equalsIgnoreCase("Link has responded with staus 204 and status text No Content")){
            System.out.println("No content link is verified");
        }
        else{
            System.out.println("link doesn't verified");
        }
        //Moved
        driver.findElement(By.linkText("Moved")).click();
        String movedLink=driver.findElement(By.id("linkResponse")).getText();

        if(movedLink.equalsIgnoreCase("Link has responded with staus 301 and status text Moved Permanently")){
            System.out.println("Moved  link is verified");
        }
        else{
            System.out.println("moved link doesn't verified");
        }

        //bad request
        driver.findElement(By.linkText("Bad Request")).click();
        String badRequestLink=driver.findElement(By.id("linkResponse")).getText();

        if(badRequestLink.equalsIgnoreCase("Link has responded with staus 400 and status text Bad Request")){
            System.out.println("Bad request link is verified");
        }
        else{
            System.out.println("Bad request link doesn't verified");
        }

        //Unauthorized
        driver.findElement(By.linkText("Unauthorized")).click();
        String unauthorizedLink=driver.findElement(By.id("linkResponse")).getText();

        if(unauthorizedLink.equalsIgnoreCase("Link has responded with staus 401 and status text Unauthorized")){
            System.out.println("Unauthorized link is verified");
        }
        else{
            System.out.println("Unauthorized link doesn't verified");
        }

        //Forbidden
        driver.findElement(By.linkText("Forbidden")).click();
        String forbiddenLink=driver.findElement(By.id("linkResponse")).getText();

        if(forbiddenLink.equalsIgnoreCase("Link has responded with staus 403 and status text Forbidden")){
            System.out.println("Forbidden link is verified");
        }
        else{
            System.out.println("Forbidden link doesn't verified");
        }

        //
        driver.findElement(By.linkText("Not Found")).click();
        String notFoundLink=driver.findElement(By.id("linkResponse")).getText();

        if(notFoundLink.equalsIgnoreCase("Link has responded with staus 404 and status text Not Found")){
            System.out.println("Not found link is verified");
        }
        else{
            System.out.println("Not found link doesn't verified");
        }












       driver.quit();








    }
}
