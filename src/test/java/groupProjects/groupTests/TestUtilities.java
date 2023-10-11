package groupProjects.groupTests;

    import org.openqa.selenium.By; // Import necessary Selenium libraries
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.Random; // Import the Random class for generating random data

    public class TestUtilities {
        // Create a class named TestUtilities for utility functions
        // Function to generate a random string of a given length
        public static String generateRandomString(int length) {
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; // Define the characters to choose from
            StringBuilder randomString = new StringBuilder(); // Create a StringBuilder to build the random string

            Random rnd = new Random(); // Create a Random object
            for (int i = 0; i < length; i++) {
                char randomChar = characters.charAt(rnd.nextInt(characters.length())); // Generate a random character
                randomString.append(randomChar); // Append the character to the random string
            }

            return randomString.toString(); // Return the random string
        }

        // Function to generate a random phone number with a country code
        public static String generateRandomPhoneNumber() {
            StringBuilder phoneNumber = new StringBuilder("+1"); // Start with a country code

            Random rnd = new Random(); // Create a Random object
            for (int i = 0; i < 10; i++) {
                int digit = rnd.nextInt(10); // Generate a random digit
                phoneNumber.append(digit); // Append the digit to the phone number
            }

            return phoneNumber.toString(); // Return the phone number as a string
        }

        // Function to clear the input field
        public static void clearInputField(WebDriver driver, By locator) {
            WebElement inputField = driver.findElement(locator); // Find the input field element
            inputField.click(); // Click on the input field
            Actions actions = new Actions(driver); // Create an Actions object
            actions.keyDown(Keys.COMMAND) // Press the COMMAND key (for Mac)
                    .sendKeys("a") // Send "a" to select all text
                    .keyUp(Keys.COMMAND) // Release the COMMAND key
                    .build() // Build the action sequence
                    .perform(); // Perform the action
            inputField.sendKeys(Keys.DELETE); // Delete the selected text
        }
    }













