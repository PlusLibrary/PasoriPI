package pasoripi.ui;

import pasoripi.model.RenderContent;
import pasoripi.resource.Resource;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Renderer {
    private static final boolean isDebug = false;
    private static final Color THEME_COLOR = new Color(0, 88, 164);
    private static final Color TIME_COLOR = Color.white;
    private static final float TIME_FONT_SIZE = 64;
    private static final int PADDING_X = 32;
    private static final int BAR_HEIGHT = 128;

    private Resource resource = Resource.getInstance();
    private final RenderContent content;
    private final Font FONT_MONO = resource.getFontMono().deriveFont(TIME_FONT_SIZE);
    private final Font FONT = resource.getFont();
    private int timeY;

    public Renderer(RenderContent content) {
        this.content = content;
    }

    public void render(Graphics2D g, JPanel panel) {
        g.clearRect(0, 0, panel.getWidth(), panel.getHeight());
        endBar(g, panel);
        time(g);
        status(g, panel);
        attendane(g);
        debug(g, panel);
    }

    private void endBar(Graphics2D g, JPanel panel) {
        g.setColor(THEME_COLOR);
        g.setFont(FONT_MONO);
        g.fillRect(0, 0, panel.getWidth(), BAR_HEIGHT);
        g.fillRect(0, panel.getHeight() - BAR_HEIGHT, panel.getWidth(), BAR_HEIGHT);
    }

    private void time(Graphics2D g) {
        timeY = timeY == 0 ? g.getFontMetrics().getHeight() : timeY;
        g.setColor(TIME_COLOR);
        g.drawString(content.getTime(), PADDING_X ,timeY);
    }

    private void status(Graphics2D g, JPanel panel) {
        g.setColor(TIME_COLOR);
        g.setFont(FONT.deriveFont(24f));
        g.drawString("ステータス：", PADDING_X, panel.getHeight() - 32);
        g.setFont(FONT_MONO.deriveFont(24f));
        g.drawString(content.getStatus(), 192, panel.getHeight() - 32);
    }

    private void attendane(Graphics2D g) {
        if (content.getName() == null) {
            return;
        }
        g.setColor(Color.BLACK);
        g.setFont(FONT.deriveFont(48f));
        g.drawString("おはようございます", PADDING_X, 384);
        g.setFont(FONT.deriveFont(96f));
        g.drawString(content.getName() + " さん", PADDING_X, 512);
    }

    private void debug(Graphics2D g, JPanel panel) {
        if (!isDebug) {
            return;
        }
        g.setColor(Color.black);
        g.drawLine(0, 0, panel.getWidth(), panel.getHeight());
        g.drawLine(0, panel.getHeight(), panel.getWidth(), 0);
    }
}
