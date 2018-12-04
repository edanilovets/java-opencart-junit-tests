package com.opencart.frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

  public HomePage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  //Top line locators
  @FindBy(xpath = "//div[@id='top-links']/ul/li[2]/a")
  @CacheLookup
  private WebElement myAccountLocator;

  @FindBy(xpath = "//div[@id='top-links']/ul/li[2]/ul/li[2]/a")
  @CacheLookup
  private WebElement loginLocator;

  @FindBy(css = "#top-links > ul > li.dropdown.open > ul > li:nth-child(5) > a")
  @CacheLookup
  private WebElement logoutLocator;

  @FindBy(xpath = "//div[@id='top-links']/ul/li[2]/ul/li[1]/a")
  @CacheLookup
  private WebElement registerLocator;

  @FindBy(xpath = "//div[@id='top-links']/ul/li[2]/ul/li[1]/a")
  @CacheLookup
  private WebElement myAccountDropdownLocator;


  public HomePage open() {
    String URL = "http://localhost:8080/opencart";
    driver.get(URL);
    return this;
  }

  public void clickLogout() {
    try {
      logoutLocator.click();
    } catch (NoSuchElementException e) {
      System.out.println("You are not Logged in...");
    }
  }

  public void clickMyAccount() {
    myAccountLocator.click();
  }

  public RegisterPage clickRegister() {
    registerLocator.click();
    return new RegisterPage(driver);
  }

  public CategoryPage clickShowAllinFirstMenuItem() {
    Actions action = new Actions(driver);
    WebElement firstMenuItem = driver.findElement(By.cssSelector("#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(1) > a"));
    WebElement showAll = driver.findElement(By.cssSelector("#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(1) > div > a"));
    action.moveToElement(firstMenuItem).moveToElement(showAll).click().build().perform();
    return new CategoryPage(driver);
  }

}
