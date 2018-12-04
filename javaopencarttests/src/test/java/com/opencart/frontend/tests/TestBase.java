package com.opencart.frontend.tests;

import com.opencart.frontend.pages.CategoryPage;
import com.opencart.frontend.pages.HomePage;
import com.opencart.frontend.pages.RegisterPage;
import com.opencart.frontend.pages.SuccessPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;



public class TestBase {
  WebDriver driver;
  HomePage homePage;
  RegisterPage registerPage;
  SuccessPage successPage;
  CategoryPage categoryPage;

  @BeforeClass
  public void init() {
    driver = new ChromeDriver();
  }

  @AfterClass
  public void tearDown(){
    driver.quit();
  }

}
