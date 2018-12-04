package com.opencart.backend.tests;

import com.opencart.backend.model.Customer;
import com.opencart.backend.model.User;
import com.opencart.backend.pages.AdminCustomersPage;
import com.opencart.backend.pages.AdminPage;
import org.junit.Assert;
import org.junit.Test;

public class AdminCustomerTest extends AdminTestBase {
  @Test
  public void canAddNewCustomer() {
    User admin = new User("admin", "admin");
    Customer customer = new Customer()
            .withFirstName("FirstName")
            .withLastName("LastName")
            .withEmail("email-0@mail.com")
            .withPhone("097-000-00-00")
            .withPassword("111111");

    AdminCustomersPage adminCustomersPage = new AdminPage(driver)
            .open()
            .loginAs(admin)
            .gotoAdminCustomersPage();

    Assert.assertTrue(adminCustomersPage.addNewCustomer(customer).isInCustomersList(customer));

  }

}
