package com.opencart.backend.tests;

import com.opencart.backend.model.Product;
import com.opencart.backend.model.ProductRegistry;
import com.opencart.backend.model.UserRegistry;
import com.opencart.backend.pages.AdminProductsPage;
import com.opencart.backend.pages.AdminPage;
import org.junit.Assert;
import org.junit.Test;


import java.util.concurrent.ThreadLocalRandom;

public class AdminProductTest extends AdminTestBase{

  @Test
  public void canAddNewProduct(){

    AdminProductsPage adminProductsPage = new AdminPage(driver)
            .open()
            .loginAs(UserRegistry.getAdmin())
            .gotoAdminProductsPage();
    Product product = ProductRegistry.getProduct();
    //Product product = new Product().withProductName("Apple iPhoneX").withMetaTagTitle("iPhoneX").withProductModel("iPhoneX");

    Assert.assertTrue(adminProductsPage.addNewProduct(product).isInProductsList(product));
  }

  @Test
  public void canEditProductAddImage(){
    AdminProductsPage adminProductsPage = new AdminPage(driver)
            .open()
            .loginAs(UserRegistry.getAdmin())
            .gotoAdminProductsPage();
    int index = ThreadLocalRandom.current().nextInt(0, 20);
    adminProductsPage.pressEditButtonByIndex(index)
            .editProductAddImage();
  }
}
