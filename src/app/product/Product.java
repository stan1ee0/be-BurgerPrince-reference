package app.product;

public abstract class Product {
    private int id;
    protected String name;
    protected int price;
    private int kcal;

    public Product(int id, String name, int price, int kcal) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.kcal = kcal;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public void printProduct(boolean printPrice) {
        if (printPrice) System.out.printf("   (%d) %s %5dKcal %5d원\n", id, name, kcal, price);
        else System.out.printf("   (%d) %s %5dKcal\n", id, name, kcal);
    }

    public abstract void printProductDetails();

    public abstract void chooseOption();
}
