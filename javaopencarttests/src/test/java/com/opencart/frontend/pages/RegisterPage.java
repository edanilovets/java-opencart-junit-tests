package com.opencart.frontend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage{

  RegisterPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @FindBy(id = "input-firstname")
  private WebElement firstNameLocator;

  @FindBy(id = "input-lastname")
  private WebElement lastNameLocator;

  @FindBy(id = "input-email")
  private WebElement emailLocator;

  @FindBy(id = "input-telephone")
  private WebElement phoneLocator;

  @FindBy(id = "input-password")
  private WebElement passwordLocator;

  @FindBy(id = "input-confirm")
  private WebElement confirmLocator;

  @FindBy(css = "#content > form > div > div > input.btn.btn-primary")
  private WebElement continueButtonLocator;

  @FindBy(xpath = "//*[@id='content']/form/div/div/input[1]")
  private WebElement privatePolicyLocator;

  @FindBy(xpath = "//*[@id='content']/form/fieldset[3]/div/div/label[1]/input")
  private WebElement subscribeYesLocator;


  public void setFirstName(String firstName) {
    firstNameLocator.sendKeys(firstName);
  }

  public void setLastName(String lastName) {
    lastNameLocator.sendKeys(lastName);
  }

  public void setEmail(String email) {
    emailLocator.sendKeys(email);
  }

  public void setPhone(String phone) {
    phoneLocator.sendKeys(phone);
  }

  public void setPassword(String password) {
    passwordLocator.sendKeys(password);
  }

  public void setConfirm(String confirm) {
    confirmLocator.sendKeys(confirm);
  }

  public void checkPrivatePolicy() {
    privatePolicyLocator.click();
  }
  
  public void setSubscribeYes() {
    subscribeYesLocator.click();
  }

  public SuccessPage clickContinue() {
    continueButtonLocator.click();
    return new SuccessPage(driver);
  }
}
