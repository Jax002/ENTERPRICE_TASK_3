import java.util.concurrent.*;

class Bar {

    static ExecutorService executorService ;
    private static final BlockingQueue<String> orders = new LinkedBlockingQueue<>();
    private static final BlockingQueue<String> drinks = new LinkedBlockingQueue<>();


    public void start(int countClient, int countBartenders) {
        executorService= Executors.newFixedThreadPool(countClient+countBartenders);
        for (int i = 0; i < countClient; i++) {
            executorService.execute(new Client(i + 1));
        }

        for (int i = 0; i < countBartenders; i++) {
            executorService.execute(new Bartender(i + 1));
        }
    }

    public static void orderDrink(String order) throws InterruptedException {
        orders.put(order);

        System.out.println("Client order: " + order);
    }

    public static void prepareDrink(int bartender) throws InterruptedException {
        String order = orders.take();
        String drink = "Drink: " + order;

        drinks.put(drink);

        System.out.println(bartender+" Barmen prepare: " + drink);

    }

    public static void serveDrink() throws InterruptedException {
        String drink = drinks.take();

        System.out.println("Issued drink: " + drink);
    }

    public void close() {

        executorService.shutdownNow();
    }


}
