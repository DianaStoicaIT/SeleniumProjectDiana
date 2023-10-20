package org.example;

import org.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SetNewPasswordPage extends BasePage {

    public SetNewPasswordPage(WebDriver driver) {
        this.driver = driver;

    }

    private By emailInput = By.id("input-email");
    private By passwordInput = By.id("input-password");
    private By loginButton = By.xpath(".//input[@value='Login']");
    private By errorMessage = By.xpath(".//div[@class = 'alert alert-danger alert-dismissible']");
    private By forgottenPassword = By.id("input-email");
    private By reEnterEmailAddress = By.className("alert alert-success alert-dismissible");
    private static By continueButton = By.xpath("//input[@value='Continue']");

    public void insertEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }
    public void insertPassword(String password) {driver.findElement(passwordInput).sendKeys(password);}
    public void clickLogin() {driver.findElement(loginButton).click();}
    public String getErrorMessage() {return driver.findElement(errorMessage).getText();}
    public void setNewPassword (String emailInput) {
        driver.findElement(By.id(emailInput)).sendKeys(emailInput);}
    public void setReEnterEmailAddress(String emailAddress){ driver.findElement(emailInput).getText();}
    public static void clickContinue() {
        driver.findElement(continueButton).click();
    }

}



