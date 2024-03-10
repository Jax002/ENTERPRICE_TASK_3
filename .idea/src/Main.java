import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Bar.barOpen=false;
                System.out.println("Bar close");

            }
        };

        Bar bar = new Bar();
        timer.schedule(task,10000);
        bar.start(100, 10);


        try {
            Thread.sleep(100);
            bar.close();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

        }
    }
}
