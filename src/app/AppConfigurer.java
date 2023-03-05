package app;

import app.product.ProductRepository;

public class AppConfigurer {
    private Menu menu = new Menu(ProductRepository.getAllProducts());
    private Cart cart = new Cart(menu());
    private Order order = new Order(cart());

    public Menu menu() {
        return menu;
    }

    public Cart cart() {
        return cart;
    }

    public Order order() {
        return order;
    }
}
