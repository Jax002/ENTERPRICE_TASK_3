import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Bar bar = new Bar();
        bar.start(8, 10);

        try {
            Thread.sleep(1000);
            bar.close();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

        }
    }
}
