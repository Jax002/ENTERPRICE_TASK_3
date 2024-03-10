public class Client implements Runnable {
    private final int id;

    public Client(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Bar.orderDrink("Drink from client number" + id);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}