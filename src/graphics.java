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
        int lbv = 70;
        int space = 23;
        for(int x1 = 10, x2 = 70, y1 = 10, y2 = 10, i = 0; i < 16; i++){
            g.drawLine(x1, y1, x2, y2);
            y1 += 30;
            g.drawLine(lbv, y1, x2, y2);
            y2 += 30;
            g.drawLine(x1, y1, x2, y2);
            y1 += space; y2 += space;
        }

    }
}
