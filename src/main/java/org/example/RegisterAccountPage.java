package org.example;
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
    private By registerAccountMandatoryFields = By.xpath("//div[@id='content']p[1]");
    private By firstNameErrorElement = By.xpath(".//div[@class = 'text-danger']");
    private By lastNameErrorElement = By.xpath(".//div[@class = 'text-danger']");
    private By emailErrorElement = By.xpath(".//div[@class = 'text-danger']");
    private By telephoneNumberErrorElement = By.xpath(".//div[@class = 'text-danger']");
    private By passwordErrorElement = By.xpath(".//div[@class = 'text-danger']");
    private By confirmPasswordErrorElement = By.xpath("//input[@name= 'confirm']/following-sibling::div");


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

    public void setRegisterAccountMandatoryFields() {
        driver.findElement((By) driver.findElement(registerAccountMandatoryFields)).click();
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

    public String getPasswordConfirmErrorMessage() {
        return driver.findElement((passwordErrorElement)).getText();
    }

    public String getConfirmationPasswordErrorMessage() {
        return driver.findElement(confirmPasswordErrorElement).getText();
    }
}



