package com.opencart.frontend.tests;

import com.opencart.frontend.model.ProductOverview;
import com.opencart.frontend.pages.CategoryPage;
import com.opencart.frontend.pages.HomePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class CategoryTest extends TestBase{

  @Test
  @DisplayName("Sorting of products in category by Name (A - Z)")
  public void canSortByNameAsc() {

    ArrayList<ProductOverview> before;
    ArrayList<ProductOverview> after;

    CategoryPage categoryPage = new HomePage(driver)
            .open()
            .showAll("Desktops");

    before = categoryPage.getListOfProductOverviews();
    categoryPage.selectSortBy("Name (A - Z)");
    after = categoryPage.getListOfProductOverviews();

    //Sort before list asc by name
    before.sort((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName()));

    Assert.assertEquals(before, after);
  }

  @Test
  @DisplayName("Sorting of products in category by Name (Z - A)")
  public void canSortByNameDesc(){

    ArrayList<ProductOverview> before;
    ArrayList<ProductOverview> after;

    CategoryPage categoryPage = new HomePage(driver)
            .open()
            .showAll("Desktops");

    before = categoryPage.getListOfProductOverviews();
    categoryPage.selectSortBy("Name (Z - A)");
    after = categoryPage.getListOfProductOverviews();

    //Sort before list desc by name
    before.sort(Collections.reverseOrder(new Comparator<ProductOverview>() {
      @Override
      public int compare(ProductOverview o1, ProductOverview o2) {
        return String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
      }
    }));

    Assert.assertEquals(before, after);
  }

  @Test
  @DisplayName("Sorting of products in category by Price (Low > High)")
  public void canSortByPriceAsc(){

    ArrayList<ProductOverview> before;
    ArrayList<ProductOverview> after;

    CategoryPage categoryPage = new HomePage(driver)
            .open()
            .showAll("Desktops");

    before = categoryPage.getListOfProductOverviews();
    categoryPage.selectSortBy("Price (Low > High)");
    after = categoryPage.getListOfProductOverviews();

    before.sort((o1, o2) -> Float.compare(o1.getPrice(), o2.getPrice()));
    Assert.assertEquals(before, after);

  }

  @Test
  @DisplayName("Sorting of products in category by Price Price (High > Low)")
  public void canSortByPriceDesc(){

    ArrayList<ProductOverview> before;
    ArrayList<ProductOverview> after;

    CategoryPage categoryPage = new HomePage(driver)
            .open()
            .showAll("Desktops");

    before = categoryPage.getListOfProductOverviews();
    categoryPage.selectSortBy("Price (High > Low)");
    after = categoryPage.getListOfProductOverviews();

    //Sorting the list of products before: first by price desc and if prices are equals by name desc
    before.sort(Collections.reverseOrder(new Comparator<ProductOverview>() {
      @Override
      public int compare(ProductOverview o1, ProductOverview o2) {
        int tmp = o1.getPrice().compareTo(o2.getPrice());
        if (tmp!=0) {
          return tmp;
        }
        return String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
      }
    }));

    Assert.assertEquals(before, after);

  }
}
