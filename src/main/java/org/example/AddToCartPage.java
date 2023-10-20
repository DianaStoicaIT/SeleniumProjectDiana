package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartPage extends org.example.BasePage {

   public void addToCartPage (WebDriver driver) {
       this.driver = driver;
   }
   private final String search_product = "HTC Touch HD";



   private static By searchButton = By.xpath(".//button[@class = 'type-text']");
    private WebElement searchInput = (WebElement) By.name("search");
    private WebElement addToCart = (WebElement) By.className("text btn btn-md btn-secondary btn-block btn-cart button-cart cart-28");


    public void enterTextToSearch(String searchText){
        driver.findElement((By) searchInput).sendKeys(searchText);
    }
    private static void clickSearchButton(){driver.findElement(searchButton).click();}
    public void clickOnAddToCart() {this.clickOnAddToCart();}







}
