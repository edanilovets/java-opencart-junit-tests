package com.opencart.backend.tests;

import com.opencart.backend.pages.DashboardPage;
import com.opencart.backend.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.*;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

import static com.opencart.backend.model.UserRegistry.getAdmin;

/**
 * Usage of ExternalResource rule
 * Can be used as replacement for @Before and @After
 *
 * Usage of TestWatcher rule
 * Taking screenshot if test failed
 *
 * Usage of Verifier rule
 * Check if during tests execution wasn't javascript errors
 *
 */

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

    @Rule
    public TestWatcher screenshotRule = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            super.succeeded(description);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            super.failed(e, description);
            System.out.println("Taking screenshot");
            File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(tmp, new File(description.getMethodName() + ".png"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        @Override
        protected void starting(Description description) {
            super.starting(description);
        }

        @Override
        protected void finished(Description description) {
            super.finished(description);
        }
    };

    @Rule
    public Verifier errorVerifier = new Verifier() {
        @Override
        protected void verify() throws Throwable {
            super.verify();
            //code to verify javascript
        }
    };

}
