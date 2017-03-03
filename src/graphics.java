import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class graphics extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.setColor(Color.black);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int space = (screen.height - (30 * 16)) / 20;
        int y1 = 10, y2 = 10;
        for (int i = 0, x1 = 10, x2 = x1 + 60; i < 16; i++) {
            g.drawLine(x1, y1, x2, y2);
            y1 += 30;
            g.drawLine(x2, y1, x2, y2);
            y2 += 30;
            g.drawLine(x1, y1, x2, y2);
            y1 += space;
            y2 += space;
        }
        y1 = 10; y2 = 10;
        for (int i = 0, x1 = screen.width - 10, x2 = x1 - 60; i < 16; i++) {
            g.drawLine(x1, y1, x2, y2);
            y1 += 30;
            g.drawLine(x2, y1, x2, y2);
            y2 += 30;
            g.drawLine(x1, y1, x2, y2);
            y1 += space;
            y2 += space;
        }
        for(int i = 0, x64L = 10, y64L = 10; i < 32; i += 2) {
            g.drawString(Main.tm.get(i), 10, y64L);
            y64L += 30;
            g.drawString(Main.tm.get(i + 1), 10, y64L);
            y64L += space;
        }
    }
}
