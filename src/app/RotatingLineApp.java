package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class RotatingLineApp extends JFrame {

    private RotatingLinePanel rotatingLinePanel;
    private Timer timer;
    private Random random;

    public RotatingLineApp() {
        setTitle("Rotating Line App");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        random = new Random();

        // Панель для обертового відрізка
        rotatingLinePanel = new RotatingLinePanel();
        add(rotatingLinePanel, BorderLayout.CENTER);

        // Меню
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem restartItem = new JMenuItem("Restart Program");
        restartItem.addActionListener(e -> restartProgram());
        fileMenu.add(restartItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        JMenuItem helpItem = new JMenuItem("Help on Rotating Line App");
        helpItem.addActionListener(e -> showHelp());
        helpMenu.add(helpItem);

        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> showAbout());
        helpMenu.add(aboutItem);

        // Таймер для оновлення анімації
        timer = new Timer(50, e -> rotatingLinePanel.repaint());
        timer.start();
    }

    private void restartProgram() {
        rotatingLinePanel.reset();
    }

    private void showHelp() {
        JOptionPane.showMessageDialog(this, "This application demonstrates a rotating line.\n" +
                "You can restart the program or exit from the File menu.\n" +
                "For more information, check the About section.", "Help", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showAbout() {
        JOptionPane.showMessageDialog(this, "Rotating Line App v1.0\n" +
                "Developed by DenKo", "About", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RotatingLineApp app = new RotatingLineApp();
            app.setVisible(true);
        });
    }

    class RotatingLinePanel extends JPanel {
        private double angle = 0;
        private Color color = Color.BLACK;

        public RotatingLinePanel() {
            setBackground(Color.WHITE);
        }

        public void reset() {
            angle = 0;
            color = Color.BLACK;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            int x1 = width / 2;
            int y1 = height / 2;
            int x2 = x1 + 100;
            int y2 = y1;

            // Оновлення кута і кольору
            angle += Math.PI / 60;
            if (angle >= 2 * Math.PI) {
                angle = 0;
                color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            }

            // Малювання відрізка з обертанням
            AffineTransform old = g2d.getTransform();
            g2d.setColor(color);
            g2d.rotate(angle, x1, y1);
            g2d.drawLine(x1, y1, x2, y2);
            g2d.setTransform(old);
        }
    }
}
