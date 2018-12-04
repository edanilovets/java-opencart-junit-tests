package com.opencart.frontend.tests;

import com.opencart.frontend.model.ProductOverview;
import com.opencart.frontend.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class CategoryTest extends TestBase{

  @Test
  public void canSortByNameAsc() {
    //option Sort By: Name (A - Z)
    ArrayList<ProductOverview> before;
    ArrayList<ProductOverview> after;

    homePage = new HomePage(driver).open();
    categoryPage = homePage.clickShowAllinFirstMenuItem();
    before = categoryPage.getListOfProductOverviews();
    categoryPage.selectSortBy("Name (A - Z)");
    after = categoryPage.getListOfProductOverviews();

    //Sort before list asc by name
    before.sort((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName()));

    Assert.assertEquals(before, after);
  }

  @Test
  public void canSortByNameDesc(){
    //option Sort By: Name (Z - A)
    ArrayList<ProductOverview> before;
    ArrayList<ProductOverview> after;

    homePage = new HomePage(driver).open();
    categoryPage = homePage.clickShowAllinFirstMenuItem();
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
  public void canSortByPriceAsc(){
    //option Sort By: Price (Low > High)
    ArrayList<ProductOverview> before;
    ArrayList<ProductOverview> after;

    homePage = new HomePage(driver).open();
    categoryPage = homePage.clickShowAllinFirstMenuItem();
    before = categoryPage.getListOfProductOverviews();
    categoryPage.selectSortBy("Price (Low > High)");
    after = categoryPage.getListOfProductOverviews();

    before.sort((o1, o2) -> Float.compare(o1.getPrice(), o2.getPrice()));
    Assert.assertEquals(before, after);

  }

  @Test
  public void canSortByPriceDesc(){
    //option Sort By: Price (High > Low)
    ArrayList<ProductOverview> before;
    ArrayList<ProductOverview> after;

    homePage = new HomePage(driver).open();
    categoryPage = homePage.clickShowAllinFirstMenuItem();
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
