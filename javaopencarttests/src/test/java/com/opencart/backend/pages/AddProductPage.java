package com.opencart.backend.pages;

import com.opencart.backend.sections.ActionPanel;
import com.opencart.backend.sections.AdminMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class AddProductPage extends BasePage {

    public AddProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    @FindBy(css = "#content > div.page-header > div > div")
    private ActionPanel actionPanel;
    @FindBy(id = "menu")
    private AdminMenu adminMenu;

    //Tabs
    @FindBy(css = "#form-product > ul > li:nth-child(2) > a")
    private WebElement tabData;
    @FindBy(css = "#form-product > ul > li:nth-child(9) > a")
    private WebElement tabImage;

    //Fields
    @FindBy(id = "input-name1")
    private WebElement productName;
    @FindBy(id = "input-meta-title1")
    private WebElement metaTagTitle;
    @FindBy(id = "input-model")
    private WebElement productModel;

    public ProductsPage cancelProductEditing() {
        actionPanel.cancel();
        return new ProductsPage(driver);
    }

    public ProductsPage saveProduct() {
        actionPanel.save();
        return new ProductsPage(driver);
    }

    public AddProductPage enterProductName(String name){
        productName.sendKeys(name);
        return this;
    }

    public AddProductPage enterMetaTagTitle(String metaTag){
        metaTagTitle.sendKeys(metaTag);
        return this;
    }

    public AddProductPage enterProductModel(String model){
        productModel.sendKeys(model);
        return this;
    }

    public AddProductPage activateDataTab(){
        tabData.click();
        return this;
    }

    public AddProductPage activateImageTab(){
        tabImage.click();
        return this;
    }

//    public ProductsPage editProductAddImage() {
//        tabImage.click();
//        driver.findElement(By.cssSelector("#thumb-image")).click();
//        driver.findElement(By.cssSelector("#button-image")).click();
//        driver.findElement(By.cssSelector("#filemanager > div > div.modal-body > div:nth-child(3) > div:nth-child(2) > a > img")).click();
//        actionPanel.save();
//        return new ProductsPage(driver);
//    }

}
