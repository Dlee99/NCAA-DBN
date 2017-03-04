import javax.swing.*;
import java.awt.*;

public class bracketFrame extends JFrame{

    public bracketFrame(){

        super("Bracket Predictor");
        graphics g = new graphics();
        setContentPane(g);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setVisible(true);

    }

}
