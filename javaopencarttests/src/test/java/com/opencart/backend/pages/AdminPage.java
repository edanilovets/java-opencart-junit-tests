package com.opencart.backend.pages;

import com.opencart.backend.model.User;
import com.opencart.backend.sections.AdminMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends AdminBasePage {
  public AdminPage(WebDriver driver) {
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

  @FindBy(id = "menu")
  public AdminMenu adminMenu; //todo: Implement elements of web page

  @FindBy(id = "menu-catalog")
  private WebElement menuCatalog;

  @FindBy(xpath = "//*[@id=\"collapse1\"]/li[2]/a")
  private WebElement menuCatalogProducts;

  @FindBy(id = "menu-customer")
  private WebElement menuCustomer;

  @FindBy(xpath = "//*[@id=\"collapse33\"]/li[1]/a")
  private WebElement menuCustomerCustomer;

  public AdminPage open() {
    driver.get("http://localhost:8080/opencart/admin/");
    return this;
  }

  public AdminPage loginAs(User user) {
    username.sendKeys(user.getName());
    password.sendKeys(user.getPassword());
    loginButton.click();
    return this;
  }

  public AdminCustomersPage gotoAdminCustomersPage() {
    menuCustomer.click();
    menuCustomerCustomer.click();
    return new AdminCustomersPage(driver);
  }

  public AdminProductsPage gotoAdminProductsPage() {
    menuCatalog.click();
    menuCatalogProducts.click();
    return new AdminProductsPage(driver);
  }
}
