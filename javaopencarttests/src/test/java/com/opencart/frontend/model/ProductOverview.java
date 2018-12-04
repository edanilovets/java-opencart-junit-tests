package com.opencart.frontend.model;

import java.util.Objects;

public class ProductOverview {
  private String name = "";
  private String description = "";
  private Float price;

  public ProductOverview withName(String name) {
    this.name = name;
    return this;
  }

  public ProductOverview withDescription(String description){
    this.description = description;
    return this;
  }

  public ProductOverview withPrice(Float price){
    this.price = price;
    return this;
  }

  public String getName(){
    return this.name;
  }

  public Float getPrice(){
    return this.price;
  }

  public String getDescription(){
    return this.description;
  }

  @Override
  public String toString() {
    return "ProductOverview{" +
            "name='" + name + '\'' +
            ", price='" + price + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductOverview that = (ProductOverview) o;
    return Objects.equals(name, that.name) &&
            Objects.equals(price, that.price);
  }

  @Override
  public int hashCode() {

    return Objects.hash(name, price);
  }
}
