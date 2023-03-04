package app.product.subproduct;

import app.product.Product;

import java.util.Scanner;

public class Drink extends Product {
    private boolean hasStraw;

    public boolean hasStraw() {
        return hasStraw;
    }

    public Drink(int id, String name, int price, int kcal, boolean hasStraw) {
        super(id, name, price, kcal);
        this.hasStraw = hasStraw;
    }

    public void printProductDetails() {
        System.out.printf("  %-8s %6d원 (빨대 %s)\n", name, price, hasStraw ? "있음" : "없음");
    }

    public void chooseOption() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("빨대가 필요하신가요? (1)_예 (2)_아니오");

        String input = scanner.nextLine();
        if (input.equals("2")) hasStraw = false;
    }
}
