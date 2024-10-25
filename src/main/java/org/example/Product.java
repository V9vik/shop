package org.example;

public class Product {
    private String name;
    private int price;
    private String company;

    public Product(String name, int price, String company) {
        this.name = name;
        this.price = price;
        this.company = company;

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %d", name, company, price);
    }

}
