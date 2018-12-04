package com.opencart.backend.pages;

import com.opencart.backend.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

  public LoginPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  //Admin login page locators
  @FindBy(id = "input-username")
  private WebElement username;

  @FindBy(id = "input-password")
  private WebElement password;

  @FindBy(css = "#content > div > div > div > div > div.panel-body > form > div.text-right > button")
  private WebElement loginButton;

  public LoginPage open() {
    driver.get("http://localhost:8080/opencart/admin/");
    return this;
  }

  public DashboardPage loginAs(User user) {
    username.sendKeys(user.getName());
    password.sendKeys(user.getPassword());
    loginButton.click();
    return new DashboardPage(driver);
  }

}
