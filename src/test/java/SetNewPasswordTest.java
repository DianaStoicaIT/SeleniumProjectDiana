import org.example.LoginPage;
import org.example.SetNewPasswordPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SetNewPasswordTest {
    private WebDriver driver;

    @Test
    public void forgottenPasswordTest (){
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        loginPage.insertEmail("johndoe@yahoo.com");
        loginPage.clickLogin();
        String actualValue = loginPage.getErrorMessage();
        String expectedValue="Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one");
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/forgotten");
        loginPage.insertEmail("johndoe@yahoo.com");
        SetNewPasswordPage.clickContinue();
        Assert.assertEquals(actualValue, expectedValue,"An email with a confirmation link has been sent your email address.");

    }
    @Test
    public void forgottenPasswordTestWithoutEmail(){
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        loginPage.clickLogin();
        String actualValue = loginPage.getErrorMessage();
        String expectedValue="Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one");
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/forgotten");
        loginPage.insertEmail("johndoe@yahoo.com");
        SetNewPasswordPage.clickContinue();
        Assert.assertEquals(actualValue, expectedValue,"An email with a confirmation link has been sent your email address.");
    }
}
                                                        