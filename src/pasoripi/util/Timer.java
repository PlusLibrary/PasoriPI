package pasoripi.util;

public class Timer {
    public static void timeOut(int ms, Runnable runnable) {
        new Thread(() -> {
            try {
                Thread.sleep(ms);
                runnable.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
