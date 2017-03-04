import javax.swing.*;
import java.awt.*;
import java.sql.Time;

public class bracketFrame extends JFrame{
    public static JFrame frame = new JFrame();
    public static void cFrame(){
     
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setVisible(true);
        graphics g = new graphics();
        frame.add(g);

    }
}
