public class Bartender implements Runnable {
    private final int id;

    public Bartender(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try  {
            while(true){
            Bar.prepareDrink(id);
            Bar.serveDrink();
        }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}