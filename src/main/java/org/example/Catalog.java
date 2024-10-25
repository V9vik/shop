package org.example;

import java.util.List;
// Применение принципа Interface Segregation Principle
// Применение принципа Open/Closed Principle
public interface Catalog {
    List<Product> getProduct();

    List<Product> filterKeyword(String keyword);

    List<Product> filterMinMax(double min, double max);

    List<Product> filterByCompany(String keyword);
}
