package com.opencart.backend.sections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(id = "menu")
public class AdminMenu extends HtmlElement {

    @FindBy(id = "menu-catalog")
    private WebElement menuCatalog;

    @FindBy(xpath = "//*[@id=\"collapse1\"]/li[2]/a")
    private WebElement menuCatalogProducts;

    @FindBy(id = "menu-customer")
    private WebElement menuCustomer;

    @FindBy(xpath = "//*[@id=\"collapse33\"]/li[1]/a")
    private WebElement menuCustomerCustomer;

    public void clickCatalog(){
        menuCatalog.click();
    }
    public void clickCatalogProducts(){
        menuCatalogProducts.click();
    }
}
