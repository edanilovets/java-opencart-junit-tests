package com.opencart.frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessPage extends BasePage {

  SuccessPage(WebDriver driver) {
    super(driver);
  }
  
  public String getSuccessMessage(){
    return driver.findElement(By.cssSelector("#content > p:nth-child(2)")).getText();
  }
  
}
