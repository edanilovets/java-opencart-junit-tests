package com.opencart.frontend.tests;

import com.opencart.frontend.pages.HomePage;
import org.junit.Test;

public class OrderTest extends TestBase {
  @Test
  public void canOrderProductFromFeaturedOnHomePage() {
    homePage = new HomePage(driver).open();
    //homePage.addRandomFeatureProductToCart();
    //todo: Implement test case
  }
}

