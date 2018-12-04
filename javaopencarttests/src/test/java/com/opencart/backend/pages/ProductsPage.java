package com.opencart.backend.pages;

import com.opencart.backend.model.Product;
import com.opencart.backend.sections.ActionPanel;
import com.opencart.backend.sections.AdminMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    @FindBy(css = "#content > div.page-header > div > div")
    private ActionPanel actionPanel;
    @FindBy(id = "menu")
    private AdminMenu adminMenu;

    public AddProductPage clickAddNew(){
        actionPanel.add();
        return new AddProductPage(driver);
    }

    public boolean isInProductsList(Product product) {
        List<WebElement> lines = driver.findElements(By.cssSelector("#form-product > div > table > tbody > tr"));
        for (WebElement element : lines) {
            String productName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String productModel = element.findElement(By.cssSelector("td:nth-child(4)")).getText();
            if (productName.equals(product.getProductName()) && productModel.equals(product.getProductModel())) {
                return true;
            }
        }
        return false;
    }

    public boolean isInNotProductsList(Product product) {
        return !isInProductsList(product);
    }

    public AddProductPage pressEditButtonByIndex(int index) {
        WebElement editButton = driver.findElements(By.cssSelector("#form-product > div > table > tbody > tr > td > a")).get(index);
        editButton.click();
        return new AddProductPage(driver);
    }

}
