package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Product> item;

    public Cart() {
        this.item = new ArrayList<>();
    }
// Применение принципа Liskov Substitution Principle
    public void addItem(Product product) {
        item.add(product);
    }

    public void clear() {
        item.clear();
    }

    public void remove(Product product) {
        item.removeIf(p -> p.getName().equalsIgnoreCase(product.getName()));
    }

    public double totalCost() {
        double sum = 0;
        for (Product product : item) {
            sum += product.getPrice();
        }
        return sum;
    }

    public boolean isEmpty() {
        return item.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Корзина:").append(System.lineSeparator());
        for (Product item : item) {
            sb.append(item).append(System.lineSeparator());
        }
        return String.valueOf(sb);
    }
}
