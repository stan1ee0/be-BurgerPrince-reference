package app.product;

public abstract class Product {
    private int id;
    protected String name;
    private int kcal;
    protected int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(int id, String name, int price, int kcal) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.kcal = kcal;
    }

    public void printProduct() {
        System.out.printf("   (%d) %s %5dKcal %5d원\n", id, name, kcal, price);
    }

    public abstract void printProductDetails();

    public abstract void chooseOption();
}
