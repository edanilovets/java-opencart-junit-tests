package com.opencart.backend.rules;

import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassRules {
    private static WebDriver driver;

    @ClassRule
    private static ExternalResource driverRule = new WebDriverRule();

    private static class WebDriverRule extends ExternalResource {
        @Override
        protected void before() throws Throwable {
            super.before();
            driver = new ChromeDriver();
        }

        @Override
        protected void after() {
            super.after();
            driver.quit();
        }
    }
}
