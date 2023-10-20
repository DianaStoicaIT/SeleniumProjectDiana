import org.example.*;
import org.example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Util.TestUtil.generateRandomEmail;

public class addToCartTest extends BasePage {
    private WebDriver driver;
    private RegisterAccountPage registerAccountPage;
    private WishlistPage wishlistPage;
    private SearchResultPage searchResultPage;

    private String loginPageURL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";

    @BeforeClass
    public void setUp() {
        System.out.println("Initialize driver.");
        driver = new ChromeDriver();
        registerAccountPage = new RegisterAccountPage(driver);
        wishlistPage = new WishlistPage(driver);
        searchResultPage = new SearchResultPage(driver);
        createAccount();
    }

    private void createAccount() {
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Navigate to " + loginPageURL);

        public void addToCart(){
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        enterTextToSearch("HTC Touch HD");
        Actions action = new Actions(driver);
       addToCartTest.clickSearchButton();
        Actions actions = new Actions(driver);
        addToCartTest.addFirstItemToCart();
    }

        public void createAccount()
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

    private static void addFirstItemToCart() {
    }

    private static void clickSearchButton() {
    }
}

