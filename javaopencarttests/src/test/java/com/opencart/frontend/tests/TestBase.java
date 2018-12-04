package com.opencart.frontend.tests;

import com.opencart.frontend.pages.CategoryPage;
import com.opencart.frontend.pages.HomePage;
import com.opencart.frontend.pages.RegisterPage;
import com.opencart.frontend.pages.SuccessPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestBase {
  static WebDriver driver;
  HomePage homePage;
  RegisterPage registerPage;
  SuccessPage successPage;
  CategoryPage categoryPage;

  @BeforeClass
  public static void init() {
    driver = new ChromeDriver();
  }

  @AfterClass
  public static void tearDown(){
    driver.quit();
  }

}
