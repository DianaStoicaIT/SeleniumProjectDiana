import org.example.BasePage;
import org.example.DashBoardPage;
import org.example.RegisterAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Util.TestUtil.generateRandomEmail;

public class DashboardTests extends BasePage {

    private WebDriver driver;
    private RegisterAccountPage registerAccountPage;
    private DashBoardPage dashBoardPage;


    public void setUp() {
        System.out.println("Initialize driver.");
        driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
        createAccount();
    }

    @BeforeMethod
    public void beforeMethod() {
        registerAccountPage = new RegisterAccountPage(driver);
        dashBoardPage = new DashBoardPage(driver);
    }

    @Test
    public void verifyDashboardFirstSection() {
        String expectedFirstSectionHeaderText = "My account";
        String expectedEditAccountElementText = "Edit your account information";
        Assert.assertEquals(dashBoardPage.getFirstSectionHeaderText(), expectedFirstSectionHeaderText,
                "First section header text is not the expected one");
        Assert.assertEquals(dashBoardPage.getEditAccountElementText(), expectedEditAccountElementText,
                "Edit account text is not the expected one");
    }


    public void createAccount() {
        System.out.println("Creating new account to be used in tests...");
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("0123456");
        registerAccountPage.setPassword("password1234");
        registerAccountPage.setPasswordConfirm("password1234");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        System.out.println("Creating new account to be used in tests...Done");
    }
}
