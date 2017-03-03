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
        g.drawLine(10,40,70,40);
        g.drawLine(71,70,71,40);
        g.drawLine(10,70,70,70);

        
                g.drawLine(10,100,70,100);
        g.drawLine(70,100,70,130);
        g.drawLine(10,130,70,130);
    }
}
