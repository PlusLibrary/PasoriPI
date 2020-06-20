package pasoripi.external;

import static pasoripi.external.Common.execute;
import java.util.Optional;

public class Pasori {
    private static Pasori pasori;
    private Pasori () {

    }

    public String read() {
        return execute("sudo python pasori.py").findAny().orElse("");
    }

    public static Pasori getInstance() {
        return Optional.ofNullable(pasori).orElse(pasori = new Pasori());
    }
}
