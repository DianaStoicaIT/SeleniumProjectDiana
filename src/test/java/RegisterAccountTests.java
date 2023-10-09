import org.example.RegisterAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Random;
import static Util.TestUtil.generateRandomEmail;

public class RegisterAccountTests {
    private WebDriver driver;
    RegisterAccountPage registerAccountPage;
    private String loginPageURL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";

    @BeforeClass
    public void setUp() {
        System.out.println("Initialize driver.");
        driver = new ChromeDriver();

    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Navigate to " + loginPageURL);
        driver.get(loginPageURL);
        registerAccountPage = new RegisterAccountPage(driver);
    }

    @Test
    public void registerNewAccountMandatoryFieldsTest() throws Exception {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        Random random = new Random();
        String email = "johndoe" + random.nextLong() + "@email.com";
        System.out.println("Used email is: " + email);
        registerAccountPage.insertEmail(email);
        registerAccountPage.insertPhoneNumber("0123456");
        registerAccountPage.setPassword("password1234");
        registerAccountPage.setPasswordConfirm("password1234");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        Thread.sleep(5000);
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        String actualText = accountCreatedPage.getParagraphText();
        String expectedText = "Congratulations! Your new account has been successfully created!";
        Assert.assertEquals(actualText, expectedText, "Actual text is not the expected one. ");

    }

    @Test
    public void registerWithoutPrivacyPolicyTest() {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        Random random = new Random();
        String email = "johndoe" + random.nextLong() + "@email.com";
        System.out.println("Used email is: " + email);
        registerAccountPage.insertEmail((generateRandomEmail()));
        registerAccountPage.insertPhoneNumber("0123456");
        registerAccountPage.setPassword("password1234");
        registerAccountPage.setPasswordConfirm("password1234");
        registerAccountPage.clickContinue();
        String actualValue = registerAccountPage.getErrorMessage();
        String expectedValue = "Warning: You must agree to the Privacy Policy!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one");

    }

    @Test
    public void registerAccountWithoutFirstNameTest() {
        registerAccountPage.insertLastName("Doe");
        Random random = new Random();
        String email = "johndoe" + random.nextLong() + "@email.com";
        System.out.println("Used email is: " + email);
        registerAccountPage.insertEmail((generateRandomEmail()));
        registerAccountPage.insertPhoneNumber("0123456");
        registerAccountPage.setPassword("password1234");
        registerAccountPage.setPasswordConfirm("password1234");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        String actualValue = registerAccountPage.getFirstNameErrorMessage();
        String expectedValue = "First Name must be between 1 and 32 characters!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one");

    }

    @Test
    public void registerAccountWithoutLastNameTest() {
        registerAccountPage.insertFirstName("John");
        Random random = new Random();
        String email = "johndoe" + random.nextLong() + "@email.com";
        System.out.println("Used email is: " + email);
        registerAccountPage.insertEmail((generateRandomEmail()));
        registerAccountPage.insertPhoneNumber("0123456");
        registerAccountPage.setPassword("password1234");
        registerAccountPage.setPasswordConfirm("password1234");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        String actualValue = registerAccountPage.getLastNameErrorMessage();
        String expectedValue = "Last Name must be between 1 and 32 characters!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one");

    }
    @Test
    public void setRegisterAccountPageWithoutEmail(){
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertPhoneNumber("0123456");
        registerAccountPage.setPassword("password1234");
        registerAccountPage.setPasswordConfirm("password1234");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        String actualValue = registerAccountPage.getEmailErrorMessage();
        String expectedValue = "E-Mail Address does not appear to be valid!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one");
}
    @Test
    public void setRegisterAccountPageWithoutTelephoneNumber(){
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        Random random = new Random();
        String email = "johndoe" + random.nextLong() + "@email.com";
        System.out.println("Used email is: " + email);
        registerAccountPage.insertEmail((generateRandomEmail()));
        registerAccountPage.setPassword("password1234");
        registerAccountPage.setPasswordConfirm("password1234");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        String actualValue = registerAccountPage.getTelephoneNumberErrorMessage();
        String expectedValue = "Telephone must be between 3 and 32 characters!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one");

    }
    @Test
    public void setRegisterAccountPageWithoutPassword(){
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        Random random = new Random();
        String email = "johndoe" + random.nextLong() + "@email.com";
        System.out.println("Used email is: " + email);
        registerAccountPage.insertEmail((generateRandomEmail()));
        registerAccountPage.insertPhoneNumber("0123456");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        String actualValue = registerAccountPage.getPasswordConfirmErrorMessage();
        String expectedValue = "Password must be between 4 and 20 characters!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one");

    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}