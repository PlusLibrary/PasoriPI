package pasoripi.external;

import java.util.Optional;

import static pasoripi.external.Common.execute;

public class Beep {
    private static Beep beep;
    private Beep () {

    }

    public void beep() {
        execute("sudo python beep.py");
    }

    public static Beep getInstance() {
        return Optional.ofNullable(beep).orElse(beep = new Beep());
    }
}
