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

        System.out.println("🧺 장바구니");
        System.out.println("-".repeat(60));

        printCartItemDetails();

        System.out.println("-".repeat(60));
        System.out.printf("합계 : %d원\n", calculateTotalPrice());

        System.out.println("이전으로 돌아가려면 엔터를 누르세요. ");
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

        System.out.printf("[📣] %s를(을) 장바구니에 담았습니다.\n", product.getName());
    }

    private void composeSet(Hamburger hamburger) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("사이드를 골라주세요");
        menu.printSides(false);

        String sideId = scanner.nextLine();
        Side side = (Side) ProductRepository.produceById(Integer.parseInt(sideId));
        side.chooseOption();
        hamburger.setSide(side);

        System.out.println("음료를 골라주세요.");
        menu.printDrinks(false);

        String drinkId = scanner.nextLine();
        Drink drink = (Drink) ProductRepository.produceById(Integer.parseInt(drinkId));
        drink.chooseOption();
        hamburger.setDrink(drink);

        hamburger.setName(hamburger.getName() + "세트");
        hamburger.setPrice(hamburger.getBurgerSetPrice());
        hamburger.setKcal(hamburger.getKcal() + side.getKcal() + drink.getKcal());
    }
}
