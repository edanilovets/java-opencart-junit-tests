package com.opencart.frontend.pages;

import com.opencart.frontend.model.ProductOverview;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CategoryPage extends BasePage {
  CategoryPage(WebDriver driver) {
    super(driver);
  }

  public void selectSortBy(String text) {
    Select sortByDropdown = new Select(driver.findElement(By.id("input-sort")));
    sortByDropdown.selectByVisibleText(text);
  }

  public ArrayList<ProductOverview> getListOfProductOverviews() {
    ArrayList<ProductOverview> productOverviews = new ArrayList<>();
    List<WebElement> featured = driver.findElements(By.cssSelector("#content .product-layout"));
    for (WebElement product: featured){
      String name = product.findElement(By.cssSelector("h4 a")).getText();
      String description = product.findElement(By.cssSelector("div.caption > p:nth-child(2)")).getText();
      String price = product.findElement(By.cssSelector(".price")).getAttribute("innerText");
      String[] prices = price.split("\\n");
      prices = prices[0].split(" ");
      StringBuilder sb = new StringBuilder(prices[0]);
      sb.deleteCharAt(0);
      Float resultPrice = Float.valueOf(sb.toString().replace(",",""));
      productOverviews.add(new ProductOverview().withName(name).withDescription(description).withPrice(resultPrice));
    }
    return productOverviews;
  }

}
