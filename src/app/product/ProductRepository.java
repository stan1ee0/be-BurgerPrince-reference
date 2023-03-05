package app.product;

import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

public class ProductRepository {
    private static final Product[] products = {
            new Hamburger(1, "새우버거", 3500, 500, false, 4500),
            new Hamburger(2, "치킨버거", 4000, 600, false, 5000),
            new Side(3, "감자튀김", 1000, 300, 1),
            new Side(4, "어니언링", 1000, 300, 1),
            new Drink(5, "코카콜라", 1000, 200, true),
            new Drink(6, "제로콜라", 1000, 0, true),
    };

    public static Product[] getAllProducts() {
        return products;
    }

    public static Product produceById(int id) {
        Product product = products[id-1];

        if (product instanceof Hamburger) {
            return new Hamburger((Hamburger) product);
        }
        if (product instanceof Side) {
            return new Side((Side) product);
        }
        if (product instanceof Drink) {
            return new Drink((Drink) product);
        }
        return null;
    }
}
