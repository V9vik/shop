package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Apple iPhone", 1000, "Apple"));
        products.add(new Product("Samsung Galaxy", 900, "Samsung"));
        products.add(new Product("Google Pixel", 800, "Google"));
        products.add(new Product("OnePlus Nord", 500, "OnePlus"));
        Catalog catalog = new SimpleCatalog(products);
        Cart cart = new Cart();

        boolean running = true;
        Scanner input = new Scanner(System.in);
        while (running) {
            System.out.println("1. Просмотреть доступные продукты");
            System.out.println("2. Фильтровать продукты по ключевому слову");
            System.out.println("3. Фильтровать продукты по ценовому диапазону");
            System.out.println("4. Фильтровать продукты по производителю");
            System.out.println("5. Добавить продукт в корзину");
            System.out.println("6. Удалить продукт из корзины");
            System.out.println("7. Просмотреть корзину");
            System.out.println("8. Выход");
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    catalog.getProduct().forEach(System.out::println);
                    Thread.sleep(1500);
                    break;
                case "2":
                    System.out.println("Введите слово для поиска:");
                    String keyword = input.nextLine();
                    catalog.filterKeyword(keyword).forEach(System.out::println);
                    Thread.sleep(1500);
                    break;
                case "3":
                    System.out.println("Введите минимальное сумму поиска:");
                    double min = input.nextInt();
                    System.out.println("Введите максимальную сумму поиска:");
                    double max = input.nextInt();
                    catalog.filterMinMax(min, max).forEach(System.out::println);
                    Thread.sleep(1500);
                    break;
                case "4":
                    System.out.println("Введите компанию которую ищите:");
                    String keyWordCompany = input.nextLine();
                    catalog.filterByCompany(keyWordCompany).forEach(System.out::println);
                    Thread.sleep(1500);
                    break;
                case "5":
                    System.out.println("Введите название чего хотите добавить в корзину");
                    String findName = input.nextLine();
                    Product findProduct = findByName(products, findName);
                    if (findProduct != null) {
                        cart.addItem(findProduct);
                        System.out.println("Удачно добавлено в корзину");
                    } else {
                        System.out.println("Ошибка, продукт не найден");
                    }
                    Thread.sleep(1500);
                    break;
                case "6":
                    System.out.println("Введите название что хотите убрать из корзины");
                    String findNameRemove = input.nextLine();
                    Product findProductRemove = findByName(products, findNameRemove);
                    if (findProductRemove != null) {
                        cart.remove(findProductRemove);
                        System.out.println("Удачно убрано из корзины");
                    } else {
                        System.out.println("Ошибка, продукт не найден");
                    }
                    Thread.sleep(1500);
                    break;
                case "7":
                    System.out.println(cart);
                    Thread.sleep(1500);
                    break;

                case "8":
                    running = false;
                    System.out.println("Приходите еще!");
            }
        }
    }
    // Принцип DRY (Don't Repeat Yourself)
   // Применение принципа Liskov Substitution Principle
    private static Product findByName(List<Product> product, String name) {
        return product.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}