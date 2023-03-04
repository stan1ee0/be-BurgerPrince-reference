package app;

import app.product.Product;

import java.util.Arrays;
import java.util.Scanner;

public class Cart {
    private Product[] items = new Product[0];

    public void printCart() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🧺 장바구니");
        System.out.println("-".repeat(60));

        for (Product product : items) {
            product.printProductDetails();
        }

        System.out.println("-".repeat(60));
        System.out.printf("합계 : %d원\n", calculateTotalPrice());

        System.out.println("이전으로 돌아가려면 엔터를 누르세요. ");
        scanner.nextLine();
    }

    public void addToCart(Product product) {
        items = Arrays.copyOf(items, items.length + 1);
        items[items.length - 1] = product;
    }

    private int calculateTotalPrice() {
        int totalPrice = 0;
        for (Product product : items) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
