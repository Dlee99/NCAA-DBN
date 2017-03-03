import javax.swing.*;
import java.awt.*;

public class bracketFrame extends JFrame{
    public static void cFrame(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(2000,1300);
        frame.setVisible(true);
        graphics g = new graphics();
        frame.add(g);


    }
}