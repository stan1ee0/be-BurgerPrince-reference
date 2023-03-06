package app;

import app.product.ProductRepository;

import java.util.Scanner;

public class OrderApp {
    private Menu menu;
    private Cart cart;
    private Order order;

    public OrderApp(Menu menu, Cart cart, Order order) {
        this.menu = menu;
        this.cart = cart;
        this.order = order;
    }

    void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🍔 BurgerPrince Order Service");
        while (true) {
            menu.printMenu();
            String input = scanner.nextLine();

            if (input.equals("+")) {
                order.makeOrder();
                break;
            }
            else if (input.equals("0")) {
                cart.printCart();
            }
            else {
                int productId = Integer.parseInt(input);
                if (1 <= productId &&
                        productId <= ProductRepository.getAllProducts().length)
                    cart.addToCart(productId);
            }
        }
    }
}
