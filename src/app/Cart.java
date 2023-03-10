package app;

import app.product.Product;
import app.product.ProductRepository;
import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

import java.util.Arrays;
import java.util.Scanner;

public class Cart {
    private Product[] items = new Product[0];
    private Menu menu;

    public Cart(Menu menu) {
        this.menu = menu;
    }

    void printCart() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("๐งบ ์ฅ๋ฐ๊ตฌ๋");
        System.out.println("-".repeat(60));

        printCartItemDetails();

        System.out.println("-".repeat(60));
        System.out.printf("ํฉ๊ณ : %d์\n", calculateTotalPrice());

        System.out.println("์ด์ ์ผ๋ก ๋์๊ฐ๋ ค๋ฉด ์ํฐ๋ฅผ ๋๋ฅด์ธ์. ");
        scanner.nextLine();
    }

    void printCartItemDetails() {
        for (Product product : items) {
            product.printProductDetails();
        }
    }

    int calculateTotalPrice() {
        int totalPrice = 0;
        for (Product product : items) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    void addToCart(int productId) {
        Product product = ProductRepository.produceById(productId);
        product.chooseOption();

        if (product instanceof Hamburger) {
            Hamburger hamburger = (Hamburger) product;
            if (hamburger.isBurgerSet()) composeSet(hamburger);
        }

        items = Arrays.copyOf(items, items.length + 1);
        items[items.length - 1] = product;

        System.out.printf("[๐ฃ] %s๋ฅผ(์) ์ฅ๋ฐ๊ตฌ๋์ ๋ด์์ต๋๋ค.\n", product.getName());
    }

    private void composeSet(Hamburger hamburger) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("์ฌ์ด๋๋ฅผ ๊ณจ๋ผ์ฃผ์ธ์");
        menu.printSides(false);

        String sideId = scanner.nextLine();
        Side side = (Side) ProductRepository.produceById(Integer.parseInt(sideId));
        side.chooseOption();
        hamburger.setSide(side);

        System.out.println("์๋ฃ๋ฅผ ๊ณจ๋ผ์ฃผ์ธ์.");
        menu.printDrinks(false);

        String drinkId = scanner.nextLine();
        Drink drink = (Drink) ProductRepository.produceById(Integer.parseInt(drinkId));
        drink.chooseOption();
        hamburger.setDrink(drink);

        hamburger.setName(hamburger.getName() + "์ธํธ");
        hamburger.setPrice(hamburger.getBurgerSetPrice());
        hamburger.setKcal(hamburger.getKcal() + side.getKcal() + drink.getKcal());
    }
}
