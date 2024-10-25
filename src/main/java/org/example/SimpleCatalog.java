package org.example;

import java.util.ArrayList;
import java.util.List;
// Применение принципа Open/Closed Principle
// Применение принципа Single Responsibility Principle
        public class SimpleCatalog implements Catalog {
    private final List<Product> products;

    public SimpleCatalog(List<Product> products) {
        this.products = products;
    }

    @Override
    public List<Product> getProduct() {
        return new ArrayList<>(products);
    }

    @Override
    public List<Product> filterKeyword(String keyword) {
        List<Product> filterProduct = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                filterProduct.add(product);
            }
        }
        return filterProduct;
    }

    @Override
    public List<Product> filterMinMax(double min, double max) {
        List<Product> filterProduct = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                filterProduct.add(product);
            }
        }
        return filterProduct;
    }

    @Override
    public List<Product> filterByCompany(String keyword) {
        List<Product> filterProduct = new ArrayList<>();
        for (Product product : products) {
            if (product.getCompany().toLowerCase().contains(keyword.toLowerCase())) {
                filterProduct.add(product);
            }
        }
        return filterProduct;
    }
}
