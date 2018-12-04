package com.opencart.backend.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {
  static WebDriver driver;

  @BeforeClass
  public static void init() {
    driver = new ChromeDriver();
  }

  @AfterClass
  public static void tearDown() {
    driver.quit();
  }


}
