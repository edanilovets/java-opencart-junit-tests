package com.opencart.backend.tests;

import com.opencart.backend.pages.DashboardPage;
import com.opencart.backend.pages.LoginPage;
import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.rules.RuleChain;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.opencart.backend.model.UserRegistry.getAdmin;

public class TestBaseRules {
    private static WebDriver driver;
    static DashboardPage dashboardPage;

    private static ExternalResource driverRule = new ExternalResource() {
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
    };


    private static ExternalResource loginRule = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            super.before();
            dashboardPage = new LoginPage(driver)
                    .open()
                    .loginAs(getAdmin());
        }

        @Override
        protected void after() {
            super.after();
            dashboardPage = new DashboardPage(driver).openDashboardPage();
        }
    };

    @ClassRule
    public static RuleChain rules = RuleChain
            .outerRule(driverRule)
            .around(loginRule);

}
