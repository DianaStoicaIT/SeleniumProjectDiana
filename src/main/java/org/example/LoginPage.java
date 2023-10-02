package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends org.example.BasePage {

    public LoginPage(WebDriver driver)  {
        this.driver = driver;
    }
    private By emailInput = By.id("input-email");
    private By passwordInput = By.id("input-password");
    private By loginButton = By.xpath(".//input[@value='Login']");



    public void insertEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }
    public void insertPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(loginButton).click();

    }
}
