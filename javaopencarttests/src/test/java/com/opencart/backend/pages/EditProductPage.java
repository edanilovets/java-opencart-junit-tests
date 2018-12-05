package com.opencart.backend.pages;

import com.opencart.backend.sections.ActionPanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class EditProductPage extends BasePage {

    EditProductPage(WebDriver driver) {
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
    private TextInput productName;
    @FindBy(id = "input-meta-title1")
    private TextInput metaTagTitle;
    @FindBy(id = "input-model")
    private TextInput productModel;

    public ProductsPage cancelProductEditing() {
        actionPanel.cancel();
        return new ProductsPage(driver);
    }

    public ProductsPage saveProduct() {
        actionPanel.save();
        return new ProductsPage(driver);
    }

    public EditProductPage enterProductName(String name){
        productName.sendKeys(name);
        return this;
    }

    public EditProductPage clearProductName(){
        productName.clear();
        return this;
    }

    public EditProductPage enterMetaTagTitle(String metaTag){
        metaTagTitle.sendKeys(metaTag);
        return this;
    }

    public EditProductPage enterProductModel(String model){
        productModel.sendKeys(model);
        return this;
    }

    public EditProductPage activateDataTab(){
        tabData.click();
        return this;
    }

    public EditProductPage activateImageTab(){
        tabImage.click();
        return this;
    }

}
