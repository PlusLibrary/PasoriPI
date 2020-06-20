package pasoripi.ui;

import pasoripi.model.RenderContent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeWatcher {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
    public static void run(RenderContent content) {
        new Thread(() -> {
            LocalDateTime time = LocalDateTime.now();
            try {
                while (true) {
                    Thread.sleep(100);
                    if (LocalDateTime.now().getSecond() != time.getSecond()) {
                        time = LocalDateTime.now();
                        content.setTime(time.format(TIME_FORMATTER));
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
