package com.opencart.backend.tests;

import com.opencart.backend.model.Product;
import com.opencart.backend.model.ProductRegistry;
import com.opencart.backend.model.UserRegistry;
import com.opencart.backend.pages.AddProductPage;
import com.opencart.backend.pages.DashboardPage;
import com.opencart.backend.pages.LoginPage;
import com.opencart.backend.pages.ProductsPage;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public class ProductTest extends TestBase {

  @Test
  public void canAddNewProductOnlyWithRequiredFields(){
    Product product = ProductRegistry.getProduct();

    DashboardPage dashboardPage = new LoginPage(driver)
            .open()
            .loginAs(UserRegistry.getAdmin());
    AddProductPage addProductPage = dashboardPage.openProductsPage().clickAddNew();
    ProductsPage productsPage = addProductPage.enterProductName(product.getProductName())
            .enterMetaTagTitle(product.getMetaTagTitle())
            .activateDataTab()
            .enterProductModel(product.getProductModel())
            .saveProduct();

    Assert.assertTrue(productsPage.isInProductsList(product));

  }

  @Test
  public void canCancelAddingOfNewProduct(){
    Product product = ProductRegistry.getProduct();

    DashboardPage dashboardPage = new LoginPage(driver)
            .open()
            .loginAs(UserRegistry.getAdmin());

    Assert.assertTrue(dashboardPage.openProductsPage().isNotInProductsList(product));
    Assert.assertTrue(dashboardPage.openProductsPage()
            .clickAddNew()
            .enterProductName(product.getProductName())
            .enterMetaTagTitle(product.getMetaTagTitle())
            .cancelProductEditing()
            .isNotInProductsList(product));
  }

  @Test
  public void canDeleteProductFromList(){
    DashboardPage dashboardPage = new LoginPage(driver)
            .open()
            .loginAs(UserRegistry.getAdmin());
    ProductsPage productsPage = dashboardPage.openProductsPage();
    int index = ThreadLocalRandom.current().nextInt(0, 10);
    Product product = productsPage.getProductByIndex(index);
    Assert.assertTrue(productsPage.isInProductsList(product));
    productsPage.selectProductByIndex(index)
            .deleteProduct();
    Assert.assertTrue(productsPage.isNotInProductsList(product));
  }


  @Test
  @Ignore
  public void canEditProductAddImage(){
//    ProductsPage adminProductsPage = new LoginPage(driver)
//            .open()
//            .loginAs(UserRegistry.getAdmin())
//            .openAdminProductsPage();
//    int index = ThreadLocalRandom.current().nextInt(0, 20);
//    adminProductsPage.pressEditButtonByIndex(index)
//            .editProductAddImage();
  }
}
