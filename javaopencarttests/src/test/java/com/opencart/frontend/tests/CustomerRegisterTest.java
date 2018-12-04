package com.opencart.frontend.tests;

import com.opencart.frontend.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerRegisterTest extends TestBase {
  
  @Test
  public void customerRegisterWithoutSubscription() {
    homePage = new HomePage(driver).open();
    homePage.clickMyAccount();
    registerPage = homePage.clickRegister();

    //Fill form on register page
    registerPage.setFirstName("Eugene");
    registerPage.setLastName("Danilovets");
    registerPage.setEmail("eugene.danilovets@gmail.com");
    registerPage.setPhone("+38099-333-22-11");
    registerPage.setPassword("111111");
    registerPage.setConfirm("111111");
    registerPage.checkPrivatePolicy();

    successPage = registerPage.clickContinue();
    Assert.assertEquals(successPage.getSuccessMessage(),
            "Congratulations! Your new account has been successfully created!");
  }
  
  @Test
  public void customerRegisterWithSubscription() {
    //todo: Implement test
  }
}
