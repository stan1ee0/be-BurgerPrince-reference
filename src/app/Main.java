package app;

public class Main {
    public static void main(String[] args) {
        AppConfigurer appConfigurer = new AppConfigurer();

        OrderApp app = new OrderApp(appConfigurer.menu(),
                appConfigurer.cart(), appConfigurer.order());
        app.start();
    }
}
