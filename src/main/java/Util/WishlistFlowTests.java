package Util;

import org.example.RegisterAccountPage;
import org.example.SearchResultPage;
import org.example.WishlistPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

import static Util.TestUtil.generateRandomEmail;

public class WishlistFlowTests {

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

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Navigate to " + loginPageURL);

    }
    @Test
    public void addItemToWishlist() throws Exception{
        wishlistPage.clickWishlist();
        String actualResult = wishlistPage.getNoResultsElementText();
        String expectedResult = "No results!";
        Assert.assertEquals(actualResult, expectedResult, "Text from element is not the expected one");
        wishlistPage.enterTextToSearch("Apple Cinema 30'");
        wishlistPage.clickSearchButton();
        Thread.sleep(4000);
        Actions action = new Actions(driver);
        action.moveToElement(searchResultPage.getFirstItem()).perform();
        searchResultPage.addFirstItemToWishlist();
        searchResultPage.clickClosePopupButton();
       searchResultPage.clickWishlist();
       int noOfItems = wishlistPage.getWishlistItems().size();
       Assert.assertTrue(noOfItems == 1, "Wishlist is empty");
        wishlistPage.clickRemoveItemFromWishlistButton();
        actualResult = wishlistPage.getNoResultsElementText();
        Assert.assertEquals(actualResult, expectedResult, "Text from element is not the expected one");


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
