import org.example.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Util.TestUtil.generateRandomEmail;

public class LoginTests {
    private WebDriver driver;

    @Test
    public void loginFieldsTests() {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        loginPage.insertEmail(generateRandomEmail());
        loginPage.insertPassword("randomPassword");
        loginPage.clickLogin();
        String actualValue = loginPage.getErrorMessage();
        String expectedValue="Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(actualValue, expectedValue,"Error message is not the expected one");

    }
    @Test
    public void loginIntoAccountWithoutEmail() {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        loginPage.insertPassword("randomPassword");
        loginPage.clickLogin();
        String actualValue = loginPage.getErrorMessage();
        String expectedValue="Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one");
    }

    @Test
    public void loginIntoAccountWithoutPassword() {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        loginPage.insertEmail(generateRandomEmail());
        loginPage.clickLogin();
        String actualValue = loginPage.getErrorMessage();
        String expectedValue="Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one");
    }
}
