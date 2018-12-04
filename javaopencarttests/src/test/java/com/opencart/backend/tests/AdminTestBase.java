package com.opencart.backend.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AdminTestBase {
  WebDriver driver;

  @BeforeClass
  public void init() {
    driver = new ChromeDriver();
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }


}
