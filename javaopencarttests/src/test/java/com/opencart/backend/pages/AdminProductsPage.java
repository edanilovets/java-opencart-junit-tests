package com.opencart.backend.pages;

import com.opencart.backend.model.Product;
import com.opencart.backend.sections.ActionPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminProductsPage extends AdminBasePage {

    AdminProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Action Panel
    private ActionPanel actionPanel;

    //Navigation
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/a")
    private WebElement addNewButton;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/button")
    private WebElement saveButton;

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

    public AdminProductsPage addNewProduct(Product product) {
        addNewButton.click();
        productName.sendKeys(product.getProductName());
        metaTagTitle.sendKeys(product.getMetaTagTitle());
        tabData.click();
        productModel.sendKeys(product.getProductModel());
        saveButton.click();
        return this;
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

    public AdminProductsPage pressEditButtonByIndex(int index) {
        WebElement editButton = driver.findElements(By.cssSelector("#form-product > div > table > tbody > tr > td > a")).get(index);
        editButton.click();
        return this;
    }


        public AdminProductsPage editProductAddImage() {
        tabImage.click();
        driver.findElement(By.cssSelector("#thumb-image")).click();
        driver.findElement(By.cssSelector("#button-image")).click();
        driver.findElement(By.cssSelector("#filemanager > div > div.modal-body > div:nth-child(3) > div:nth-child(2) > a > img")).click();
        saveButton.click();
        //actionPanel.saveButton.click();
        return this;
    }
}
