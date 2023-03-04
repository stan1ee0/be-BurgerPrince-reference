package app;

import app.product.ProductRepository;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu(ProductRepository.getAllProducts());
        Cart cart = new Cart();

        OrderApp app = new OrderApp(menu, cart);
        app.start();
    }
}
