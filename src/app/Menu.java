package app;

import app.product.Product;
import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

public class Menu {
    private Product[] products;

    public Menu(Product[] products) {
        this.products = products;
    }

    public void printMenu() {
        System.out.println("[🔻] 메뉴");
        System.out.println("-".repeat(60));

        printHamburgers();
        printSides();
        printDrinks();

        System.out.println();
        System.out.println("🧺 (0) 장바구니");
        System.out.println("📦 (+) 주문하기");
        System.out.println("-".repeat(60));
        System.out.print("[📣] 메뉴를 선택해주세요 : ");
    }

    private void printHamburgers() {
        System.out.println("🍔 햄버거");
        for (Product product : products) {
            if (product instanceof Hamburger) {
                product.printProduct();
            }
        }
        System.out.println();
    }

    void printSides() {
        System.out.println("🍟 사이드");
        for (Product product : products) {
            if (product instanceof Side) {
                product.printProduct();
            }
        }
        System.out.println();
    }

    void printDrinks() {
        System.out.println("🥤 음료");
        for (Product product : products) {
            if (product instanceof Drink) {
                product.printProduct();
            }
        }
        System.out.println();
    }
}
