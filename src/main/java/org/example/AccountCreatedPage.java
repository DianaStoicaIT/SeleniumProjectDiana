package org.example;

import org.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountCreatedPage extends BasePage {
    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    private By paragraphElement = By.xpath("//div[@id='content']p[1]");
    public String getParagraphText() {
        return driver.findElement(paragraphElement).getText();
    }
}
