package com.opencart.backend.tests;

import com.opencart.backend.model.Product;
import com.opencart.backend.pages.DashboardPage;
import com.opencart.backend.pages.LoginPage;
import com.opencart.backend.pages.ProductsPage;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;
import static com.opencart.backend.model.ProductRegistry.*;
import static com.opencart.backend.model.UserRegistry.*;

public class ProductTest extends TestBase {

  @Test
  public void canAddNewProductOnlyWithRequiredFields(){
    Product product = getProduct();

    DashboardPage dashboardPage = new LoginPage(driver)
            .open()
            .loginAs(getAdmin());

    ProductsPage productsPage = dashboardPage
            .openProductsPage()
            .clickAddNewProductButton()
            .enterProductName(product.getProductName())
            .enterMetaTagTitle(product.getMetaTagTitle())
            .activateDataTab()
            .enterProductModel(product.getProductModel())
            .saveProduct();

    Assert.assertTrue(productsPage.isInProductsList(product));

  }

  @Test
  public void canCancelAddingOfNewProduct(){
    Product product = getProduct();

    DashboardPage dashboardPage = new LoginPage(driver)
            .open()
            .loginAs(getAdmin());

    Assert.assertTrue(dashboardPage.openProductsPage().isNotInProductsList(product));
    Assert.assertTrue(dashboardPage
            .openProductsPage()
            .clickAddNewProductButton()
            .enterProductName(product.getProductName())
            .enterMetaTagTitle(product.getMetaTagTitle())
            .cancelProductEditing()
            .isNotInProductsList(product));
  }

  @Test
  public void canDeleteProductFromList(){

    //index for selecting product
    int index = ThreadLocalRandom.current().nextInt(0, 10);

    DashboardPage dashboardPage = new LoginPage(driver)
            .open()
            .loginAs(getAdmin());

    ProductsPage productsPage = dashboardPage.openProductsPage();
    Product product = productsPage.getProductByIndex(index);

    Assert.assertTrue(productsPage.isInProductsList(product));
    productsPage.selectProductByIndex(index).deleteProduct();
    Assert.assertTrue(productsPage.isNotInProductsList(product));
  }


  @Test
  public void canEditExistingProductModifyProductName(){

    //index for selecting product
    int index = ThreadLocalRandom.current().nextInt(0, 10);

    DashboardPage dashboardPage = new LoginPage(driver)
            .open()
            .loginAs(getAdmin());

    ProductsPage productsPage = dashboardPage.openProductsPage();
    Product product = productsPage.getProductByIndex(index);

    ProductsPage productsPage1 = productsPage
            .pressEditButtonByIndex(index)
            .clearProductName()
            .enterProductName("Modified Name")
            .saveProduct();

    Assert.assertFalse(productsPage1.isInProductsList(product));
    product.withProductName("Modified Name");
    Assert.assertTrue(productsPage1.isInProductsList(product));
  }

}
