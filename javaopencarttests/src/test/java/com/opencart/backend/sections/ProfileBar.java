package com.opencart.backend.sections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@FindBy(css = "#header > div > ul")
public class ProfileBar {
  @FindBy(css = "#header > div > ul > li.dropdown > a")
  private WebElement userLink;
  @FindBy(css = "#header > div > ul > li.dropdown.open > ul > li:nth-child(1) > a")
  private WebElement yourProfile;
  @FindBy(css = "#header > div > ul > li:nth-child(2) > a")
  private WebElement logout;

  public void clickLogout(){
    logout.click();
  }
  public void clickUserDropdown(){
    userLink.click();
  }
  public void  clickYourProfile(){
    yourProfile.click();
  }

}
