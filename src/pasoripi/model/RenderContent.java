package pasoripi.model;

import java.util.Optional;

public class RenderContent {
    private String time = "";
    private String status = "";
    private String name;
    private Optional<Runnable> runnable;

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void setTime(String time) {
        this.time = time;
        runnable.ifPresent(Runnable::run);
    }

    public void setStatus(String status) {
        this.status = status;
        runnable.ifPresent(Runnable::run);
    }

    public void setName(String name) {
        this.name = name;
        runnable.ifPresent(Runnable::run);
    }

    public void setCallback(Runnable runnable) {
        this.runnable = Optional.of(runnable);
    }
}
