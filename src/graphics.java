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
        int width = 60; //implement standardization for window size
        int y1 = 10, y2 = 10;
        for (int i = 0, x1 = 10, x2 = x1 + width; i < 16; i++) {
            g.drawLine(x1, y1, x2, y2);
            y1 += 30;
            g.drawLine(x2, y1, x2, y2);
            y2 += 30;
            g.drawLine(x1, y1, x2, y2);
            y1 += space;
            y2 += space;
        }
        y1 = 10; y2 = 10;
        for (int i = 0, x1 = screen.width - 10, x2 = x1 - width; i < 16; i++) {
            g.drawLine(x1, y1, x2, y2);
            y1 += 30;
            g.drawLine(x2, y1, x2, y2);
            y2 += 30;
            g.drawLine(x1, y1, x2, y2);
            y1 += space;
            y2 += space;
        }
        for(int i = 0, x64L = 10, y64L = 10; i < 32; i += 2) {
            g.drawString(Main.tm.get(i), x64L, y64L);
            y64L += 30;
            g.drawString(Main.tm.get(i + 1), x64L, y64L);
            y64L += space;
        }
        /*
        for(int x1=70, x2=160,yy1=25,yy2=25,i=0; i<16; i++) {
            g.drawLine(x1, yy1, x2, yy2);
            yy1 += 60;
            yy2 += 60;

        }
        for(int x1=160, yyy1=25, x2=160, yyy2=85, i=0; i<8;i++ ){
            g.drawLine(x1, yyy1  , x2, yyy2);
            yyy1+=120;
            yyy2+=120;



        }
        */
        y1 = 25; y2 = 25;
        for (int i = 0, x1 = 70, x2 = x1 + width; i < 8; i++) {
            g.drawLine(x1, y1, x2, y2);
            y1 += 30 + space;
            g.drawLine(x2, y1, x2, y2);
            y2 += 30 + space;
            g.drawLine(x1, y1, x2, y2);
            y1 += 30 + space;
            y2 += 30 + space;
        }
    }
}
