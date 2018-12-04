package com.opencart.backend.pages;

import com.opencart.backend.sections.ActionPanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductPage extends BasePage {

    AddProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#content > div.page-header > div > div")
    private ActionPanel actionPanel;

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
