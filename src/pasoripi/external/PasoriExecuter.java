package pasoripi.external;

import pasoripi.model.RenderContent;
import pasoripi.util.Timer;

import java.util.Map;
import java.util.Optional;

public class PasoriExecuter {
    private static PasoriExecuter executer;
    private Pasori pasori = Pasori.getInstance();
    private final RenderContent content;
    private Beep beep = Beep.getInstance();

    private void start() {
        Map<String, String> map = Map.of(
                "011202128C1A4C05", "滝本 ひふみ",
                "0101031065147230","南 ことり");
        new Thread(() -> {
            String string;
            while((string = pasori.read()) != null) {
                System.out.println(string);
                String name = map.get(string);
                if (name != null) {
                    beep.beep();
                    Timer.timeOut(5000, () -> {
                        content.setName(null);
                    });
                    content.setName(name);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private PasoriExecuter(RenderContent content) {
        this.content = content;
        start();
    }

    public static void start(RenderContent content) {
        Optional.ofNullable(executer).orElse(executer = new PasoriExecuter(content));
    }
}
