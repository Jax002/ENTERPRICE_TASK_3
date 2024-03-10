public class Client implements Runnable {
    private final int id;

    public Client(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (Bar.barOpen) {
            try {
                Bar.orderDrink("Drink from client number " + id);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}