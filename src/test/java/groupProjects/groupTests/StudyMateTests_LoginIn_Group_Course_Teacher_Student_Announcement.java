package groupProjects.groupTests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import tests.utilities.Driver;
import utilities.Driver;
import java.time.Duration;
import java.util.Random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudyMateTests_LoginIn_Group_Course_Teacher_Student_Announcement extends TestUtilities{

    private static WebDriver driver;// Declare the WebDriver as a class variable

    @BeforeClass
    public static void setUp() {
        // Initialize the WebDriver before the test class
        driver = Driver.getDriver();
    }

    //------------------- Login Section -------------------

    @Test
    public void a_TestOfLoginAndLogoutFunctionality() throws InterruptedException {
        //**Test Case 1: Invalid Username**
        //- **Test Scenario:** Verify that the system displays an error message when an invalid username is entered.
        //- **Test Steps:**
        //  1. Navigate to the login page.
        //  2. Enter an invalid username (e.g., a username that does not exist) and a valid password.
        //  3. Click the "Login" button.
        //- **Expected Result:** The system should display an error message indicating that the login failed due to
        // an invalid username.

        driver.get("https://codewiser.studymate.us/login");
        String invalidUsername = "invalidusername@codewise.com";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement usernameInput = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@name='email']"))));
        usernameInput.sendKeys(invalidUsername);
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@name='password']"))));
        passwordInput.sendKeys("codewise123");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(text(),'Log in')]"))));
        loginButton.click();
        String expectedErrorMessage = new String("User with email " + invalidUsername + " not found");
        clearInputField(driver, By.xpath("//input[@name='email']"));// clearing email field
        clearInputField(driver, By.xpath("//input[@name='password']"));//clearing password field

        //**Test Case 2: Invalid Password**
        //- **Test Scenario:** Verify that the system displays an error message when an invalid password is entered.
        //- **Test Steps:**
        //  1. Navigate to the login page.
        //  2. Enter a valid username and an invalid password (e.g., an incorrect password).
        //  3. Click the "Login" button.
        //- **Expected Result:** The system should display an error message indicating that the login failed due to an
        // invalid password.

        usernameInput.sendKeys("admin@codewise.com");
        passwordInput.sendKeys("invalidPassword123");
        loginButton.click();
        WebElement errorMessagePassword = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div/p[contains(text(),'Invalid password')]"))));
        String expectedMessageInvalidPassword = "Invalid password";
        String actualResultInvalidPassword = errorMessagePassword.getText();
        Assert.assertEquals(expectedMessageInvalidPassword, actualResultInvalidPassword); //checks if error message for invalid password is correct
        clearInputField(driver, By.xpath("//input[@name='email']"));// clearing email field
        clearInputField(driver, By.xpath("//input[@name='password']"));//clearing password field

        //**Test Case 3: Empty Username**
        //- **Test Scenario:** Verify that the system handles the case when the username field is left empty.
        //- **Test Steps:**
        //  1. Navigate to the login page.
        //  2. Leave the username field empty and enter a valid password.
        //  3. Click the "Login" button.
        //- **Expected Result:** The system should display an error message indicating that the login failed due
        // to the empty username field.

        passwordInput.sendKeys("codewise123");
        loginButton.click();
        WebElement errorMessageEmptyEmail = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div/p/span[contains(text(),'Email is required!')]"))));
        String expectedErrorMessageEmptyEmail = "Email is required!";
        String actualErrorMessageEmptyEmail = errorMessageEmptyEmail.getText();
        Assert.assertEquals(expectedErrorMessageEmptyEmail, actualErrorMessageEmptyEmail);
        clearInputField(driver, By.xpath("//input[@name='password']"));//clearing password field

        //**Test Case 4: Empty Password**
        //- **Test Scenario:** Verify that the system handles the case when the password field is left empty.
        //- **Test Steps:**
        //  1. Navigate to the login page.
        //  2. Enter a valid username and leave the password field empty.
        //  3. Click the "Login" button.
        //- **Expected Result:** The system should display an error message indicating that the login failed due to the
        // empty password field.

        usernameInput.sendKeys("admin@codewise.com");
        loginButton.click();
        WebElement errorMessageEmptyPassword = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div//p/span[contains(text(),'Password is required!')]"))));
        String actualErrorMessageEmptyPassword = errorMessageEmptyPassword.getText();
        String expectedErrorMessageEmptyPassword = "Password is required!";
        Assert.assertEquals(actualErrorMessageEmptyPassword, expectedErrorMessageEmptyPassword);
        clearInputField(driver, By.xpath("//input[@name='email']"));// clearing email field

        //**Test Case 5: Successful Login**
        //- **Test Scenario:** Verify that a user can successfully log in with valid credentials.
        //- **Test Steps:**
        //  1. Navigate to the login page.
        //  2. Enter a valid username and password.
        //  3. Click the "Login" button.
        //- **Expected Result:** The user should be granted access to their account without any error messages.

        usernameInput.sendKeys("admin@codewise.com");
        passwordInput.sendKeys("codewise123");
        loginButton.click();
        wait.until(ExpectedConditions.urlMatches("https://codewiser.studymate.us/admin/analytics"));
        Thread.sleep(3000);
        String expectedURL = "https://codewiser.studymate.us/admin/analytics";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);

        //*Test Case 6: Verification of confirmation message before logout happens*
        //- **Preconditions:** User is logged in and currently on a web application page.
        //- **Test Steps:**
        //  1. Click on the "Logout" button or option in the user profile or navigation menu.
        //- **Expected Result:**
        // - The user see confirmation message "Do you really want to log out?"

        WebElement administrator = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//header//p[contains(text(),'Administrator')]"))));
        administrator.click();
        WebElement logOut = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@role='presentation']//ul/li"))));
        logOut.click();
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(" //div/p[contains(text(),'Do you really want to log out?')]"))));
        String actualConfirmationMessage = confirmationMessage.getText();
        String expectedConfirmationMessage = "Do you really want to log out?";
        Assert.assertEquals(actualConfirmationMessage, expectedConfirmationMessage);

        //*Test Case 7: Verification of  logout cancel button*
        //- **Preconditions:** User is logged in and currently on a web application page.
        //- **Test Steps:**
        //  1. Click on the "Logout" button or option in the user profile or navigation menu.
        //- **Expected Result:**
        // - The user see confirmation message "Do you really want to log out?" and have an option to press cancel button
        // - The user press cancel button and stays at the current web application page.

        WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div/button[contains(text(),'Cancel')]"))));
        cancelButton.click();
        String actualURLAfterLogin = driver.getCurrentUrl();
        String expectedURLAfterLogin = "https://codewiser.studymate.us/admin/analytics";
        Assert.assertEquals(actualURLAfterLogin, expectedURLAfterLogin);
        Thread.sleep(3000);

        //*Test Case 8: Normal Logout*
        //- **Preconditions:** User is logged in and currently on a web application page.
        //- **Test Steps:**
        //  1. Click on the "Logout" button or option in the user profile or navigation menu.
        //- **Expected Result:**
        //  - The user is logged out.
        //  - The system redirects the user to the login page.
        //  - The user can no longer access their account without logging in again.

        logOut.click();
        WebElement confirmLogoutButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div/button[contains(text(),'Log out')]"))));
        confirmLogoutButton.click();
        String expectedURLAfterLogOut = "https://codewiser.studymate.us/login";
        String currentURLAfterLogOut = driver.getCurrentUrl();
        Assert.assertEquals(expectedURLAfterLogOut, currentURLAfterLogOut);

    }


    //------------------- Reg Login Section -------------------

    
    // This method is executed before the main sections test and is used for logging in.
    @Test
    public void b_RegLoginToTestDiffSections() {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate and fill in the email field with the provided email
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@name='email']"))));
        emailField.sendKeys("admin@codewise.com");

        // Locate and fill in the password field with the provided password
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("codewise123");

        // Click the login button
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

        // You are now logged in.
    }


    //------------------- Group Section -------------------


    @Test
    //Creates and delete group
    public void c_CreateAndDeleteGroup() {
        WebElement groupButton = driver.findElement(By.xpath("//li[contains(text(),'Groups')]"));
        groupButton.click();

        WebElement createGroup = driver.findElement(By.xpath("//button[contains(text(),'Create group')]"));
        createGroup.click();

        WebElement groupName = driver.findElement(By.id(":r4:"));
        groupName.click();
        String randomNameOfCourse = generateRandomString(10);
        groupName.sendKeys(randomNameOfCourse);

        WebElement description = driver.findElement(By.id(":r7:"));
        description.click();
        String randomDescriptionOfCourse = generateRandomString(20);
        description.sendKeys(randomDescriptionOfCourse);

        WebElement dateOfCreation = driver.findElement(By.id(":r5:"));
        dateOfCreation.click();
        dateOfCreation.sendKeys("09.13.2023");

        WebElement create = driver.findElement(By.xpath("//form[@id='group-form']//button[contains(text(),'Create')]"));
        create.click();

    }


    //------------------- Course Section -------------------


    @Test
    public void d_CreateCourse() throws InterruptedException {

        // Click on the "Courses" tab
        driver.findElement(By.xpath("//li[contains(text(),'Courses')]")).click();

        // Click the "Create course" button
        driver.findElement(By.xpath("//button[contains(text(),'Create course')]")).click();

        // Find the course name input field
        WebElement courseName = driver.findElement(By.name("courseName"));
        courseName.click();

        // Provide a random course name
        String randomString1 = generateRandomString(8);
        courseName.sendKeys(randomString1);

        // Find the input field for the course creation date
        WebElement dateOfCreateCourse = driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']"));
        dateOfCreateCourse.click();

        // Provide a course creation date
        dateOfCreateCourse.sendKeys("06.09.2023");

        // Find the input field for the course description
        WebElement description = driver.findElement(By.xpath("//div//textarea[@name='description']"));
        description.click();

        // Provide a random course description
        String randomString2 = generateRandomString(20);
        description.sendKeys(randomString2);

        // Click the "Create" button to create the course
        driver.findElement(By.xpath("//form[@id='courseForm']//button[contains(text(),'Create')]")).click();

        // Wait for a few seconds to allow the UI to update
        Thread.sleep(5000); // Sleep for 5 seconds (5000 milliseconds)

        // Explicitly wait for the text to be "from 2"
        WebElement numberOfCourses = driver.findElement(By.xpath("(//p[@class =\"css-7zvtr8\"])[3]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(numberOfCourses, "from 2"));

        // Assert that the content displays "from 2" after adding the course.
        assertEquals("from 2", numberOfCourses.getText());
    }


    @Test
    public void e_AssignCourseTeacher() throws InterruptedException {
        // Assign a teacher to the course
        // Click the "Assign Teacher" button
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[1]/div[1]/div[3]/div/button")).click();

        // Select the first teacher from the list
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[1]")).click();

        // Enable the checkbox for the teacher assignment
        driver.findElement(By.xpath("//form/div/div/div")).click();
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        Actions actions = new Actions(driver);

        // Double-click the "Save" button to save the teacher assignment
        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Save']"));
        Thread.sleep(3000); // Sleep for 3 seconds
        actions.doubleClick(clickButton).perform();
        clickButton.click();
    }


    @Test
    public void f_DeleteCourse() throws InterruptedException {

        Thread.sleep(5000); // Sleep for 5 seconds (5000 milliseconds)


        // Click the "Delete" button to remove the course
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[1]/div[1]/div[3]/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[3]")).click();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();

        // Wait for a few seconds to allow the UI to update
        Thread.sleep(5000); // Sleep for 5 seconds (5000 milliseconds)

        // Explicitly wait for the text to be "from 2"
        WebElement numberOfCourses = driver.findElement(By.xpath("(//p[@class =\"css-7zvtr8\"])[3]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(numberOfCourses, "from 1"));

        // Assert that the content displays "from 1" after deleting the course.
        assertEquals("from 1", numberOfCourses.getText());

    }


//------------------- Teacher Section -------------------


    @Test
    public void g_AddingTeacher() throws InterruptedException {
        // Click on the "Teacher" link
        WebElement teacher = driver.findElement(By.xpath("//div[@id='root']//a[4]/li"));
        teacher.click();

        Thread.sleep(3000);

        // Click the button to add a new teacher
        driver.findElement(By.xpath("//span[@class='MuiButton-startIcon MuiButton-iconSizeMedium css-6xugel']")).click();

        // Find and enter a random first name
        WebElement firstNameButton = driver.findElement(By.xpath("(//input[@class = 'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[3]"));
        firstNameButton.click();
        firstNameButton.sendKeys(generateRandomString(4));

        // Find and enter a random last name
        WebElement lastNameButton = driver.findElement(By.xpath("(//input[@class = 'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[4]"));
        lastNameButton.click();
        lastNameButton.sendKeys(generateRandomString(6));

        // Find and enter a random phone number
        WebElement phoneNumButton = driver.findElement(By.xpath("(//input[@class = 'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[5]"));
        phoneNumButton.click();
        phoneNumButton.sendKeys(generateRandomPhoneNumber());

        // Find and enter a random email address
        WebElement emailButton = driver.findElement(By.xpath("(//input[@class = 'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[6]"));
        emailButton.click();
        emailButton.sendKeys(generateRandomString(7) + "@gmail.com");

        // Find and enter the specialization (e.g., "Business Analyst")
        WebElement specializationButton = driver.findElement(By.xpath("(//input[@class = 'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[7]"));
        specializationButton.click();
        specializationButton.sendKeys("Business Analyst");

        // Click the button to choose courses
        WebElement chooseCourses = driver.findElement(By.xpath("//div[@role='button']"));
        chooseCourses.click();

        // Select courses (you may need to add more specific comments here)
        WebElement courses = driver.findElement(By.xpath("//span//input[@class='PrivateSwitchBase-input css-1m9pwf3']"));
        courses.click();

        // Store the parent window handle
        String parentWindow = driver.getWindowHandle();

        // Perform actions on the pop-up window (you may need to add more specific comments here)
        driver.findElement(By.xpath("//div[@id='menu-']")).click();

        // Click the "Add" button
        WebElement addBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        addBtn.click();
        Thread.sleep(4000);

        System.out.println(driver.getTitle());
    }

    @Test
    public void h_CancelTeacher() {
        // Click the button to add a new teacher
        driver.findElement(By.xpath("//span[@class='MuiButton-startIcon MuiButton-iconSizeMedium css-6xugel']")).click();

        // Find and enter a random first name
        WebElement firstNameButton = driver.findElement(By.xpath("(//input[@class = 'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[3]"));
        firstNameButton.click();
        firstNameButton.sendKeys(generateRandomString(4));

        // Find and enter a random last name
        WebElement lastNameButton = driver.findElement(By.xpath("(//input[@class = 'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[4]"));
        lastNameButton.click();
        lastNameButton.sendKeys(generateRandomString(6));

        // Find and enter a random phone number
        WebElement phoneNumButton = driver.findElement(By.xpath("(//input[@class = 'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[5]"));
        phoneNumButton.click();
        phoneNumButton.sendKeys(generateRandomPhoneNumber());

        // Find and enter a random email address
        WebElement emailButton = driver.findElement(By.xpath("(//input[@class = 'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[6]"));
        emailButton.click();
        emailButton.sendKeys(generateRandomString(7) + "@gmail.com");

        // Find and enter the specialization (e.g., "Business Analyst")
        WebElement specializationButton = driver.findElement(By.xpath("(//input[@class = 'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[7]"));
        specializationButton.click();
        specializationButton.sendKeys("Business Analyst");

        // Click the "Cancel" button
        WebElement cancelBtn = driver.findElement(By.xpath("//button[contains(text(),'Cancel')]"));
        cancelBtn.click();
    }

    @Test
    public void i_removeTeacher() throws InterruptedException {
        // Remove a teacher
        driver.findElement(By.xpath("(//Button[@class = 'MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[2]")).click();
        driver.findElement(By.xpath("(//li[@class = 'MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-l5jx0u'])[4]")).click();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        Thread.sleep(4000);
    }





    //------------------- Student Section -------------------


    @Test
    public void j_AddStudent() throws InterruptedException {

        // Set a page load timeout
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate and click the "Students" tab
        WebElement studentTab = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href=\"/admin/students\"]"))));
        studentTab.click();

        // You are now on the student tab.

        // Click on the "Add Student" button
        driver.findElement(By.xpath("//*[contains(text(),'Add st')]")).click();

        Actions actions = new Actions(driver);

        // Generate random name, last name, phone number, and email
        String randomName = generateRandomString(4); // 4-letter name
        String randomLastName = generateRandomString(6); // 6-letter last name
        String randomPhoneNumber = generateRandomPhoneNumber(); // 10-digit phone number
        String randomEmail = generateRandomString(8) + "@gmail.com"; // 8-letter random string + "@gmail.com"

        // Fill in the student information
        actions.click(driver.findElement(By.xpath("//input[@name = 'name']"))).sendKeys(randomName).build().perform();
        actions.click(driver.findElement(By.xpath("//input[@name = 'lastName']"))).sendKeys(randomLastName).build().perform();
        actions.click(driver.findElement(By.xpath("//input[@name = 'phoneNumber']"))).sendKeys(randomPhoneNumber).build().perform();
        actions.click(driver.findElement(By.xpath("//input[@name = 'email']"))).sendKeys(randomEmail).build().perform();

        // Click on the group dropdown to open it
        driver.findElement(By.xpath("(//div[@class = 'MuiSelect-select MuiSelect-outlined " +
                "MuiInputBase-input MuiOutlinedInput-input css-qiwgdb'])[1]")).click();

        // Find the option by its data-value attribute and click it
        WebElement option = driver.findElement(By.xpath("//li[@data-value='5']"));
        option.click();

        // Click on the study format dropdown and select **offline** or **online** option
        WebElement statusDropDown = driver.findElement(By.xpath("(//div[@class = 'MuiSelect-select MuiSelect-outlined " +
                "MuiInputBase-input MuiOutlinedInput-input css-qiwgdb'])[2]"));
        statusDropDown.click();

        // Generate a random number (0 or 1)
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(2);

        // Use an if statement to select the status based on the random number
        if (randomNumber == 0) {
            // Click on "ONLINE"
            WebElement onlineOption = driver.findElement(By.xpath("//li[@data-value='ONLINE']"));
            onlineOption.click();
        } else {
            // Click on "OFFLINE"
            WebElement offlineOption = driver.findElement(By.xpath("//li[@data-value='OFFLINE']"));
            offlineOption.click();
        }

        // Click on the "Add" button
        driver.findElement(By.xpath(
                "(//button[contains(text(),'Add')])[2]")).click();

        // Wait for a few seconds to allow the UI to update
        Thread.sleep(5000); // Sleep for 5 seconds (5000 milliseconds)

        // Explicitly wait for the text to be "from 2"
        WebElement numberOfStudents = driver.findElement(By.xpath("(//*[@class=\"css-7zvtr8\"])[3]"));
        wait.until(ExpectedConditions.textToBePresentInElement(numberOfStudents, "from 2"));

        // Assert that the content displays "from 2" after adding the student.
        assertEquals("from 2", numberOfStudents.getText());
    }


    @Test
    public void k_DeleteStudent() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on the delete button which will verify the student was added
        driver.findElement(By.xpath(
                "(//button[@class = \"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk\"])[4]")).click();

        // Confirm the deletion by clicking on the delete option in the confirmation menu
        WebElement deleteOption = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(
                "(//li[@class = \"MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-l5jx0u\"])[6]"))));
        deleteOption.click();

        // After confirming the deletion, click on the "Delete" button that appears
        WebElement finalDeleteButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(
                "(//*[contains(text(),'Delete')])[4]"))));
        finalDeleteButton.click();

        // Wait for a few seconds to allow the UI to update
        Thread.sleep(5000); // Sleep for 5 seconds (5000 milliseconds)

        // Explicitly wait for the text to be "from 2"
        WebElement numberOfStudents = driver.findElement(By.xpath("(//*[@class=\"css-7zvtr8\"])[3]"));
        wait.until(ExpectedConditions.textToBePresentInElement(numberOfStudents, "from 1"));

        // Assert that the content displays "from 1" after deleting the student.
        assertEquals("from 1", numberOfStudents.getText());
    }


    //------------------- Announcement Section -------------------


    @Test
    public void m_CreateAndPublishAnnouncement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on the "Announcements" link in the navigation bar
        WebElement announcementsBar = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//nav/a[@href='/admin/announcements']"))));
        announcementsBar.click();

        // Click the "Add an announcement" button
        WebElement addAnnouncementButton = driver.findElement(By.xpath("//header/button[contains(text(),'Add an announcement')]"));//case sensitive!
        addAnnouncementButton.click();

        // Find the text input field for the announcement
        WebElement announcementTextInput = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='modal']//textarea"))));
        announcementTextInput.sendKeys("This is a test announcement text.");

        // Click the checkbox to target all groups
        WebElement targetAllGroupsCheckbox = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='modal']/div/form/div/div[2]/div/div"))));
        targetAllGroupsCheckbox.click();

        // Select the "For All" option from the dropdown
        WebElement forAll = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div/ul/li[contains(text(),'Для всех')]"))));
        forAll.click();

        // Click the "Add" button to create and publish the announcement
        WebElement addButton = driver.findElement(By.xpath("(//div/button[contains(text(),'Add')])[2]"));
        addButton.click();

        // Wait for success message and assert it
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/p[contains(text(),'Announcement successfully saved')]")));
        String expectedMessage = "Announcement successfully saved";
        String actualMessage = successMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }


    @Test
    public void n_editTheAnnouncement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click the three dots button to open options
        WebElement threeDots = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div/div/div/div[3]/div/button"))));
        threeDots.click();

        // Select the "Edit" option from the menu
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div/ul/li[1]"))));
        editButton.click();

        // Find the text input field for the announcement
        WebElement announcementTextInput = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='modal']//textarea"))));

        // Clear the existing text and add modified text
        announcementTextInput.sendKeys(Keys.COMMAND + "a");
        announcementTextInput.sendKeys(Keys.DELETE);
        String modifiedText = "This is modified text";
        announcementTextInput.sendKeys(modifiedText);

        // Click the "Save" button to save the changes
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div/button[contains(text(),'Save')]"))));
        saveButton.click();

        // Wait for the modified text to appear and assert it
        String expectedModifiedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //div/p[contains(text(),'This is modified text')]"))).getText();
        Assert.assertEquals(modifiedText, expectedModifiedText);
    }


    @Test
    public void o_cancelDelete() throws InterruptedException {
        // Create a WebDriverWait with a timeout of 30 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Find and click the "Three Dots" button
        WebElement threeDots = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div/div/div/div[3]/div/button[1]"))));
        threeDots.click();

        // Find and click the "Delete" button
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div/ul/li[3]"))));
        deleteButton.click();

        Thread.sleep(3000); // Sleep for 3 seconds (3000 milliseconds)

        // Find and click the "Cancel" button
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")))).click();
    }

    @Test
    public void p_deleteAnnouncement() throws InterruptedException {
        // Create a WebDriverWait with a timeout of 30 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Find and click the "Three Dots" button
        WebElement threeDots = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div/div/div/div[3]/div/button[1]"))));
        threeDots.click();

        // Find and click the "Delete" button
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div/ul/li[3]"))));
        deleteButton.click();

        Thread.sleep(3000); // Sleep for 3 seconds (3000 milliseconds)

        // Find and click the "Delete" button
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(text(),'Delete')]")))).click();
    }





}











