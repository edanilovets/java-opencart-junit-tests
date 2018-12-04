package com.opencart.backend.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
  public WebDriver driver;

  BasePage(WebDriver driver) {
    this.driver = driver;
  }
}
