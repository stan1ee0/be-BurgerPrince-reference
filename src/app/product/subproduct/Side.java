package app.product.subproduct;

import app.product.Product;

import java.util.Scanner;

public class Side extends Product {
    private int ketchup;

    public Side(int id, String name, int price, int kcal, int ketchup) {
        super(id, name, price, kcal);
        this.ketchup = ketchup;
    }

    public Side(Side side) {
        this(side.getId(), side.getName(), side.getPrice(), side.getKcal(), side.ketchup);
    }

    public int getKetchup() {
        return ketchup;
    }

    public void printProductDetails() {
        System.out.printf("  %-8s %6d원 (케첩 %d개)\n", name, price, ketchup);
    }

    public void chooseOption() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("케첩은 몇개가 필요하신가요?");

        String input = scanner.nextLine();
        ketchup = Integer.parseInt(input);
    }
}
