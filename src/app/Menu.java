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

    void printMenu() {
        System.out.println("[๐ป] ๋ฉ๋ด");
        System.out.println("-".repeat(60));

        printHamburgers(true);
        printSides(true);
        printDrinks(true);

        System.out.println();
        System.out.println("๐งบ (0) ์ฅ๋ฐ๊ตฌ๋");
        System.out.println("๐ฆ (+) ์ฃผ๋ฌธํ๊ธฐ");
        System.out.println("-".repeat(60));
        System.out.print("[๐ฃ] ๋ฉ๋ด๋ฅผ ์ ํํด์ฃผ์ธ์ : ");
    }

    private void printHamburgers(boolean printPrice) {
        System.out.println("๐ ํ๋ฒ๊ฑฐ");
        for (Product product : products) {
            if (product instanceof Hamburger) {
                product.printProduct(printPrice);
            }
        }
        System.out.println();
    }

    void printSides(boolean printPrice) {
        System.out.println("๐ ์ฌ์ด๋");
        for (Product product : products) {
            if (product instanceof Side) {
                product.printProduct(printPrice);
            }
        }
        System.out.println();
    }

    void printDrinks(boolean printPrice) {
        System.out.println("๐ฅค ์๋ฃ");
        for (Product product : products) {
            if (product instanceof Drink) {
                product.printProduct(printPrice);
            }
        }
        System.out.println();
    }
}
