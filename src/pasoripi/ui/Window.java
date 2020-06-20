package pasoripi.ui;

import pasoripi.external.PasoriExecuter;
import pasoripi.model.RenderContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Optional;

public class Window {
    private static Window window;
    private RenderContent content = new RenderContent();
    private Renderer renderer = new Renderer(content);
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel(null) {
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
            g2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            renderer.render((Graphics2D) g, panel);
        }
    };

    private Window() {
        content.setCallback(() -> panel.repaint());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setContentPane(panel);
        panel.addKeyListener(new KeyHandler());
        panel.setBackground(Color.white);
    }

    public Window show() {
        TimeWatcher.run(content);
        PasoriExecuter.start(content);
        frame.setVisible(true);
        panel.requestFocus();
        GraphicsDevice device = frame.getGraphicsConfiguration().getDevice();
        device.setFullScreenWindow(frame);
        return this;
    }

    public static Window getInstance() {
        return Optional.ofNullable(window).orElse(window = new Window());
    }
}
