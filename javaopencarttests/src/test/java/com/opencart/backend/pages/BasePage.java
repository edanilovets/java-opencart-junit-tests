package com.opencart.backend.pages;

import com.opencart.backend.sections.AdminMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class BasePage {
  public WebDriver driver;

  BasePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
  }

  @FindBy(id = "menu")
  private AdminMenu adminMenu;

  //Admin Menu methods

  public ProductsPage openProductsPage(){
    adminMenu.clickCatalog();
    adminMenu.clickCatalogProducts();
    return new ProductsPage(driver);
  }
}
