package app;

import app.product.Product;
import app.product.ProductRepository;
import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

import java.util.Scanner;

public class OrderApp {
    private Menu menu;
    private Cart cart;
    //private Order order;

    public OrderApp(Menu menu, Cart cart) {
        this.menu = menu;
        this.cart = cart;
    }

    void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🍔 BurgerPrince Order Service");
        while (true) {
            menu.printMenu();
            String input = scanner.nextLine();

            if (input.equals("+")) {
                //order.makeOrder();
                break;
            }
            else if (input.equals("0")) {
                cart.printCart();
            }
            else {
                int num = Integer.parseInt(input);
                if (1 <= num && num <= ProductRepository.getAllProducts().length) {
                    Product product = ProductRepository.findById(num);
                    product.chooseOption();

                    if (product instanceof Hamburger &&
                            ((Hamburger) product).isBurgerSet()) {
                        composeSet((Hamburger) product);
                    }

                    cart.addToCart(product);
                }
            }
        }
    }

    private void composeSet(Hamburger hamburger) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("사이드를 골라주세요");
        menu.printSides();

        String sideId = scanner.nextLine();
        Side side = (Side) ProductRepository.findById(Integer.parseInt(sideId));
        side.chooseOption();
        hamburger.setSide(side);

        System.out.println("음료를 골라주세요.");
        menu.printDrinks();

        String drinkId = scanner.nextLine();
        Drink drink = (Drink) ProductRepository.findById(Integer.parseInt(drinkId));
        drink.chooseOption();
        hamburger.setDrink(drink);

        hamburger.setName(hamburger.getName() + "세트");
        hamburger.setPrice(hamburger.getBurgerSetPrice());
        hamburger.setKcal(hamburger.getKcal() + side.getKcal() + drink.getKcal());
    }
}
