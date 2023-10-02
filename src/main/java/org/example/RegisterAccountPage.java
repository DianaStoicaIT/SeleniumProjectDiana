package org.example;

import org.example.BasePage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RegisterAccountPage extends BasePage {

    public RegisterAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstNameInput = By.id("input-firstname");
    private By lastNameInput = By.id("input-lastname");
    private By emailInput = By.id("input-email");
    private By telephoneInput = By.id("input-telephone");
    private By passwordInput = By.id("input-password");
    private By passwordConfirmInput = By.id("input-confirm");
    private By privacyPolicyCheckbox = By.xpath("//label[@for='input-agree']");
    private By continueButton = By.xpath("//input[@value='Continue']");
    private By firstNameErrorElement = By.xpath(".//input[@name='firstname' ]/following-sibling:div");
    private By lastNameErrorElement = By.xpath(".//input[@name='lastname' ]/following-sibling:div");
    private By emailErrorElement = By.xpath(".//input[@name='email' ]/following-sibling:div");
    private By telephoneNumberErrorElement = By.id(".//div[@class = 'alert alert-danger alert-dismissible']");
    private By passwordErrorElement = By.id("input-password");
    private By passwordConfirmErrorElement = By.xpath(".//div[@class = 'text-danger']");


    public void insertFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void insertLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void insertEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void insertPhoneNumber(String phoneNumber) {
        driver.findElement(telephoneInput).sendKeys(phoneNumber);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void setPasswordConfirm(String passwordConfirm) {
        driver.findElement(passwordConfirmInput).sendKeys(passwordConfirm);
    }

    public void checkPrivacyPolicy() {
        driver.findElement(privacyPolicyCheckbox).click();
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public String getFirstNameErrorMessage() {
        return driver.findElement(firstNameErrorElement).getText();
    }

    public String getLastNameErrorMessage() {
        return driver.findElement(lastNameErrorElement).getText();
    }

    public String getEmailErrorMessage() {
        return driver.findElement(emailErrorElement).getText();
    }

    public String getTelephoneNumberErrorMessage() {
       return driver.findElement(telephoneNumberErrorElement).getText();

    }
    public String getPasswordErrorMessage(){
        return driver.findElement(passwordErrorElement).getText();
    }
    public String getPasswordConfirmErrorMessage(){
        return driver.findElement((passwordErrorElement)).getText();
    }


}
