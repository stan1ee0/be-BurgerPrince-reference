package app.product.subproduct;

import app.product.Product;

import java.util.Scanner;

public class Hamburger extends Product {
    private boolean isBurgerSet;
    private int burgerSetPrice;
    private Side side;
    private Drink drink;

    public Hamburger(int id, String name, int price, int kcal, boolean isBurgerSet, int burgerSetPrice) {
        super(id, name, price, kcal);
        this.isBurgerSet = isBurgerSet;
        this.burgerSetPrice = burgerSetPrice;
    }

    public Hamburger(Hamburger hamburger) {
        this(hamburger.getId(), hamburger.getName(), hamburger.getPrice(),
                hamburger.getKcal(), hamburger.isBurgerSet, hamburger.burgerSetPrice);
    }

    public boolean isBurgerSet() {
        return isBurgerSet;
    }

    public int getBurgerSetPrice() {
        return burgerSetPrice;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public void printProductDetails() {
        if (isBurgerSet) {
            System.out.printf("  %-8s %6d원 (%s(케첩 %d개), %s(빨대 %s))\n",
                    name, burgerSetPrice,
                    side.getName(), side.getKetchup(),
                    drink.getName(), drink.hasStraw() ? "있음" : "없음"
            );
        }
        else {
            System.out.printf("  %-8s %6d원 (단품)\n", name, price);
        }
    }

    public void chooseOption() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf(
                "단품으로 주문하시겠어요? (1)_단품(%d원) (2)_세트(%d원)\n",
                price, burgerSetPrice
        );

        String input = scanner.nextLine();
        if (input.equals("2")) isBurgerSet = true;
    }
}
