package com.opencart.backend.model;

import java.util.Objects;

public class Customer {
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String password;

  public Customer withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public Customer withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Customer withEmail(String email) {
    this.email = email;
    return this;
  }

  public Customer withPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public Customer withPassword(String password) {
    this.password = password;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Customer customer = (Customer) o;
    return Objects.equals(email, customer.email);
  }

  @Override
  public int hashCode() {

    return Objects.hash(email);
  }
}
