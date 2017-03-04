import javax.swing.*;
import java.awt.*;

public class bracketFrame extends JFrame{
    public static void cFrame(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setVisible(true);
        graphics g = new graphics();
        frame.add(g);


    }
}