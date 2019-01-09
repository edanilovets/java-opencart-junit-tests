package com.opencart.backend.pages;

import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    public DashboardPage open() {
        driver.get("http://localhost:8080/opencart/admin/");
        return this;
    }
}
