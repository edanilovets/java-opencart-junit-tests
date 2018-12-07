package com.opencart.frontend.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

  public HomePage(WebDriver driver) {
    super(driver);
  }

  //Top line locators
  @FindBy(xpath = "//div[@id='top-links']/ul/li[2]/a")
  private WebElement myAccountLocator;

  @FindBy(xpath = "//div[@id='top-links']/ul/li[2]/ul/li[2]/a")
  private WebElement loginLocator;

  @FindBy(css = "#top-links > ul > li.dropdown.open > ul > li:nth-child(5) > a")
  private WebElement logoutLocator;

  @FindBy(xpath = "//div[@id='top-links']/ul/li[2]/ul/li[1]/a")
  private WebElement registerLocator;

  @FindBy(xpath = "//div[@id='top-links']/ul/li[2]/ul/li[1]/a")
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

}
