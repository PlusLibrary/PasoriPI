package pasoripi.resource;

import java.awt.*;
import java.io.IOException;
import java.util.Optional;

public class Resource {
    private static Resource resource;
    private Font font;
    private Font fontMono;

    public Font getFont() {
        return font;
    }

    public Font getFontMono() {
        return fontMono;
    }

    private Resource init() {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/pasoripi/resource/notoSans.otf"));
            fontMono = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/pasoripi/resource/robotoMono.ttf"));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return this;
    }

    private Resource() {}

    public static Resource getInstance() {
        return Optional.ofNullable(resource).orElse(resource = new Resource().init());
    }

    static {
        getInstance();
    }
}
