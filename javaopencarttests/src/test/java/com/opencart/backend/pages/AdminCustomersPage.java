package com.opencart.backend.pages;

import com.opencart.backend.model.Customer;
import com.opencart.backend.sections.ActionPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

public class AdminCustomersPage extends AdminBasePage{
	AdminCustomersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
	}

  @FindBy(css = "#content > div.page-header > div > div")
	private ActionPanel actionPanel;

	//Fields
	@FindBy(id = "input-firstname")
	private WebElement firstNameLocator;
	@FindBy(id = "input-lastname")
	private WebElement lastNameLocator;
	@FindBy(id = "input-email")
	private WebElement emailLocator;
	@FindBy(id = "input-telephone")
	private WebElement phoneLocator;
	@FindBy(id = "input-password")
	private WebElement passwordLocator;
	@FindBy(id = "input-confirm")
	private WebElement confirmLocator;

	public AdminCustomersPage addNewCustomer(Customer customer) {
		actionPanel.add();
		firstNameLocator.sendKeys(customer.getFirstName());
		lastNameLocator.sendKeys(customer.getLastName());
		emailLocator.sendKeys(customer.getEmail());
		phoneLocator.sendKeys(customer.getPhone());
		passwordLocator.sendKeys(customer.getPassword());
		confirmLocator.sendKeys(customer.getPassword());
		actionPanel.save();
		return this;
	}

	public boolean isInCustomersList(Customer customer) {
		List<WebElement> lines = driver.findElements(By.cssSelector("#form-customer > table > tbody > tr"));
		for (WebElement element: lines){
			String email = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
			if (email.equals(customer.getEmail())){
				return true;
			}
		}
		return false;
	}
}
