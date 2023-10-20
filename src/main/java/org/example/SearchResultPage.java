package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends org.example.BasePage {
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;

    }

    private By resultItems = By.xpath(".//a[contains(@class, 'text-ellipsis-2')]");
    private By addToWishlistButton = By.xpath("./button[@title = 'Add to Wish List']");

    private By closePopUpButton = By.xpath(".//button[@aria-label = 'Close']");

    public void clickFirstItem() {
        driver.findElements(resultItems).get(0).click();
    }
    public WebElement getFirstItem() {
        return driver.findElements(resultItems).get(0);
    }

    public void addFirstItemToWishlist(){
        driver.findElements(addToWishlistButton).get(0).click();
    }
    public void clickClosePopupButton(){
        driver.findElement(closePopUpButton).click();
    }
}