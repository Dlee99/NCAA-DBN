import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class graphics extends JPanel  {
    JTextField FinalLeft = new JTextField(), FinalRight = new JTextField(), winner = new  JTextField();
    JButton button = new JButton();
    public void paintComponent(Graphics g) {
        if(FinalLeft.isVisible()){
            Main.frame.remove(FinalLeft);
            Main.frame.remove(FinalRight);
            Main.frame.remove(winner);
            Main.frame.remove(button);
        }
        Color background = Color.DARK_GRAY;
        Color text = Color.WHITE;
        super.paintComponent(g);
        this.setBackground(background);
        g.setColor(Color.white);
        Dimension screen = Main.frame.getSize();
        int space = (screen.height - (30 * 16)) / 20;
        int width = (screen.width - 20) / 12;

        //Left side Round 64 Bracket Lines
        g.setColor(text);
        int y1 = 10, y2 = 10;
        for (int i = 0, x1 = 10, x2 = x1 + width; i < 16; i++) {
            g.drawLine(x1, y1, x2, y2);
            y1 += 30;
            g.setColor(Main.RO64Color.get(i));
            g.drawLine(x2, y1, x2, y2);
            g.setColor(text);
            y2 += 30;
            g.drawLine(x1, y1, x2, y2);
            y1 += space;
            y2 += space;
        }

        //Right side Round 64 Bracket Lines

        y1 = 10;
        y2 = 10;
        for (int i = 0, x1 = screen.width - 10, x2 = x1 - width; i < 16; i++) {
            g.drawLine(x1, y1, x2, y2);
            y1 += 30;
            g.setColor(Main.RO64Color.get(i + 16));
            g.drawLine(x2, y1, x2, y2);
            g.setColor(text);
            y2 += 30;
            g.drawLine(x1, y1, x2, y2);
            y1 += space;
            y2 += space;
        }

        //Left side Round 32 Bracket Lines

        y1 = 25;
        y2 = 25;
        for (int i = 0, x1 = 10 + width, x2 = x1 + width; i < 8; i++) {
            g.drawLine(x1, y1, x2, y2);
            y1 += 30 + space;
            g.setColor(Main.RO32Color.get(i));
            g.drawLine(x2, y1, x2, y2);
            g.setColor(text);
            y2 += 30 + space;
            g.drawLine(x1, y1, x2, y2);
            y1 += 30 + space;
            y2 += 30 + space;
        }

        //Right side Round 32 Bracket Lines

        y1 = 25;
        y2 = 25;
        for (int i = 0, x1 = screen.width - width - 10, x2 = x1 - width; i < 8; i++) {
            g.drawLine(x1, y1, x2, y2);
            y1 += 30 + space;
            g.setColor(Main.RO32Color.get(i + 8));
            g.drawLine(x2, y1, x2, y2);
            g.setColor(text);
            y2 += 30 + space;
            g.drawLine(x1, y1, x2, y2);
            y1 += 30 + space;
            y2 += 30 + space;
        }

        //Left side Round 16 Bracket Lines

        y1 = 50;
        y2 = 50;
        for (int i = 0, x1 = 10 + 2 * width, x2 = x1 + width; i < 4; i++) {
            g.drawLine(x1, y1, x2, y2);
            y1 += 60 + 2 * space;
            g.setColor(Main.RO16Color.get(i));
            g.drawLine(x2, y1, x2, y2);
            g.setColor(text);
            y2 += 60 + 2 * space;
            g.drawLine(x1, y1, x2, y2);
            y1 += 60 + 2 * space;
            y2 += 60 + 2 * space;
        }

        //Right side Round 16 Bracket Lines

        y1 = 50;
        y2 = 50;
        for (int i = 0, x1 = screen.width - (width * 2) - 10, x2 = x1 - width; i < 4; i++) {
            g.drawLine(x1, y1, x2, y2);
            y1 += 60 + 2 * space;
            g.setColor(Main.RO16Color.get(i + 4));
            g.drawLine(x2, y1, x2, y2);
            g.setColor(text);
            y2 += 60 + 2 * space;
            g.drawLine(x1, y1, x2, y2);
            y1 += 60 + 2 * space;
            y2 += 60 + 2 * space;
        }

        //Left side Round 8 Bracket Lines

        y1 = 95;
        y2 = 95;
        for (int i = 0, x1 = 10 + 3 * width, x2 = x1 + width; i < 2; i++) {
            g.drawLine(x1, y1, x2, y2);
            y1 += 120 + 4 * space;
            g.setColor(Main.RO8Color.get(i));
            g.drawLine(x2, y1, x2, y2);
            g.setColor(text);
            y2 += 120 + 4 * space;
            g.drawLine(x1, y1, x2, y2);
            y1 += 120 + 4 * space;
            y2 += 120 + 4 * space;
        }

        //Right side Round 8 Bracket Lines

        y1 = 95;
        y2 = 95;
        for (int i = 0, x1 = screen.width - (width * 3) - 10, x2 = x1 - width; i < 2; i++) {
            g.drawLine(x1, y1, x2, y2);
            y1 += 120 + 4 * space;
            g.setColor(Main.RO8Color.get(i + 2));
            g.drawLine(x2, y1, x2, y2);
            g.setColor(text);
            y2 += 120 + 4 * space;
            g.drawLine(x1, y1, x2, y2);
            y1 += 120 + 4 * space;
            y2 += 120 + 4 * space;
        }

        //Left side Round 4 Bracket Lines

        y1 = 180;
        y2 = 180;
        for (int i = 0, x1 = 10 + 4 * width, x2 = x1 + width; i < 1; i++) {
            g.drawLine(x1, y1, x2, y2);
            y1 += 240 + 8 * space;
            g.setColor(Main.RO4Color.get(i));
            g.drawLine(x2, y1, x2, y2);
            y2 += 240 + 8 * space;
            g.setColor(text);
            g.drawLine(x1, y1, x2, y2);
            y1 += 240 + 8 * space;
            y2 += 240 + 8 * space;
        }

        //Right side Round 4 Bracket Lines

        y1 = 180;
        y2 = 180;

        for (int i = 0, x1 = screen.width - (width * 4) - 10, x2 = x1 - width; i < 1; i++) {
            g.drawLine(x1, y1, x2, y2);
            y1 += 240 + 8 * space;
            g.setColor(Main.RO4Color.get(i + 1));
            g.drawLine(x2, y1, x2, y2);
            g.setColor(text);
            y2 += 240 + 8 * space;
            g.drawLine(x1, y1, x2, y2);
            y1 += 240 + 8 * space;
            y2 += 240 + 8 * space;
        }

        //Championship Bracket Lines

        g.setColor(Main.FinalColor.get(0));
        g.drawLine(screen.width - (width * 7) - 120 + 100, 240 + 8 * space / 2 + 25, screen.width - (width * 4) - 10 - width - 100 + 100, 240 + 8 * space / 2 + 25);
        g.drawLine((screen.width - (width * 7) - 120 + 100 + screen.width - (width * 4) - 10 - width - 100 + 100) / 2,
                240 + 8 * space / 2 + 25,
                (screen.width - (width * 7) - 120 + 100 + screen.width - (width * 4) - 10 - width - 100 + 100) / 2,
                240 + 8 * space);
        g.setColor(text);
        //Left side Round 64 Team Names

        for (int i = 0, x64L = 10 + (width / 4) - 20, y64L = 10; i < 32; i += 2) {
            g.drawString(Main.tm.get(i)+ (" ( ")+Main.rank64.get(i)+(" )"), x64L, y64L);
            y64L += 30;
            g.drawString(Main.tm.get(i + 1)+ (" ( ")+Main.rank64.get(i+1)+(" )"), x64L, y64L);
            y64L += space;
        }

        //Right side Round 64 Team Names

        for (int i = 32, x64R = screen.width - width - 10 + (width / 4) - 20, y64R = 10; i < 64; i += 2) {
            g.drawString(Main.tm.get(i)+ ("(")+Main.rank64.get(i)+(")"), x64R, y64R);
            y64R += 30;
            g.drawString(Main.tm.get(i + 1)+ ("(")+Main.rank64.get(i+1)+(")"), x64R, y64R);
            y64R += space;
        }



        //Left side Round 32 Team Names

        for (int i = 0, x32L = 10 + width + (width / 4), y32L = 25; i < 16; i += 2) {
            g.drawString(Main.RO32TM.get(i)+ ("(")+Main.rank32.get(i)+(")"), x32L, y32L);
            y32L += 30 + space;
            g.drawString(Main.RO32TM.get(i + 1)+ ("(")+Main.rank32.get(i+1)+(")"), x32L, y32L);
            y32L += 30 + space;


        }

        //Right side Round 32 Team Names

        for (int i = 16, x32R = screen.width - (width * 2) - 10 + (width / 4), y32R = 25; i < 31; i += 2) {
            g.drawString(Main.RO32TM.get(i)+ ("(")+Main.rank32.get(i)+(")"), x32R, y32R);
            y32R += 30 + space;
            g.drawString(Main.RO32TM.get(i + 1)+ ("(")+Main.rank32.get(i+1)+(")"), x32R, y32R);
            y32R += 30 + space;


        }


        //Left side 16 Team Names

        for (int i = 0, x16L = 10 + width * 2 + (width / 4), y16L = 50; i < 8; i += 2) {
            g.drawString(Main.RO16TM.get(i)+ ("(")+Main.rank16.get(i)+(")"), x16L, y16L);
            y16L += 60 + 2 * space;
            g.drawString(Main.RO16TM.get(i + 1)+ ("(")+Main.rank16.get(i+1)+(")"), x16L, y16L);
            y16L += 60 + 2 * space;
        }

        //Right side 16 Team Names

        for (int i = 8, x16L = screen.width - (width * 3) - 10 + (width / 4), y16L = 50; i < 16; i += 2) {
            g.drawString(Main.RO16TM.get(i)+ ("(")+Main.rank16.get(i)+(")"), x16L, y16L);
            y16L += 60 + 2 * space;
            g.drawString(Main.RO16TM.get(i + 1)+ ("(")+Main.rank16.get(i+1)+(")"), x16L, y16L);
            y16L += 60 + 2 * space;
        }


        //Left side Round 8 Team Names

        for (int i = 0, x8L = 10 + width * 3 + (width / 4), y8L = 95; i < 4; i += 2) {
            g.drawString(Main.RO8TM.get(i)+ ("(")+Main.rank8.get(i)+(")"), x8L, y8L);
            y8L += 120 + 4 * space;
            g.drawString(Main.RO8TM.get(i + 1)+ ("(")+Main.rank8.get(i+1)+(")"), x8L, y8L);
            y8L += 120 + 4 * space;
        }

        //Right side Round 8 Team Names


        for (int i = 4, x8L = screen.width - (width * 4) - 10 + (width / 4), y8L = 95; i < 8; i += 2) {
            g.drawString(Main.RO8TM.get(i)+ ("(")+Main.rank8.get(i)+(")"), x8L, y8L);
            y8L += 120 + 4 * space;
            g.drawString(Main.RO8TM.get(i + 1)+ ("(")+Main.rank8.get(i+1)+(")"), x8L, y8L);
            y8L += 120 + 4 * space;
        }

        //Left side Round 4 Team Names

        for (int i = 0, x4L = 10 + width * 4 + (width / 4), y4L = 180; i < 2; i += 2) {
            g.drawString(Main.RO4TM.get(i)+ ("(")+Main.rank4.get(i)+(")"), x4L, y4L);
            y4L += 240 + 8 * space;
            g.drawString(Main.RO4TM.get(i + 1)+ ("(")+Main.rank4.get(i+1)+(")"), x4L, y4L);
            y4L += 240 + 8 * space;
        }


        //Right side Round 4 Team Names

        for (int i = 2, x4L = screen.width - (width * 5) - 10 + (width / 4), y4L = 180; i < 4; i += 2) {
            g.drawString(Main.RO4TM.get(i)+ ("(")+Main.rank4.get(i)+(")"), x4L, y4L);
            y4L += 240 + 8 * space;
            g.drawString(Main.RO4TM.get(i + 1)+ ("(")+Main.rank4.get(i+1)+(")"), x4L, y4L);
            y4L += 240 + 8 * space;
        }

        int mid = ((screen.width - (width * 7) - 120) + (screen.width - (width * 4) - 10 - width - 100)) / 2;
        FinalLeft = new JTextField();
        FinalLeft.setVisible(true);
        FinalLeft.setBackground(background);
        FinalLeft.setSize(200, 50);
        FinalLeft.setLocation(screen.width - (width * 7) - 120, 240 + 8 * space / 2);
        FinalLeft.setText(Main.FinalTM.get(0));
        FinalLeft.setHorizontalAlignment(JTextField.CENTER);
        Main.frame.add(FinalLeft);
        FinalLeft.setForeground(text);


        FinalRight = new JTextField();
        FinalRight.setVisible(true);
        FinalRight.setBackground(background);
        FinalRight.setSize(200, 50);
        FinalRight.setLocation(screen.width - (width * 4) - 10 - width - 100, 240 + 8 * space / 2);
        FinalRight.setText(Main.FinalTM.get(1));
        FinalRight.setHorizontalAlignment(JTextField.CENTER);
        Main.frame.add(FinalRight);
        FinalRight.setForeground(text);


        winner = new JTextField();
        winner.setBackground(background);
        winner.setVisible(true);
        winner.setSize(200, 50);
        winner.setLocation(mid, 240 + 8 * space);
        winner.setText(Main.FinalTM.get(0));
        winner.setHorizontalAlignment(JTextField.CENTER);

        Main.frame.add(winner);
        winner.setForeground(text);


        g.setFont(new Font("Times New Roman", Font.BOLD, 35));
        g.drawString("South", width * 3 + 10, 120 + (space * 4) ) ;
        g.drawString("West", width * 3 + 10, 360 + (space * 12));
        g.drawString("East", screen.width - 10 - (width * 4) + (width / 4) , 120 + (space * 4));
        g.drawString("Midwest",screen.width - 10 - (width * 4) + (width / 4), 360 + (space * 12));
        g.drawString("BRACKET PREDICTOR", Main.frame.getWidth() / 2 - 205, Main.frame.getHeight() / 9);
        g.drawString("WINNER", mid + 20, 255 + 12 * space + 20);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 35));
        g.drawString("Derek, Bubb, Nirali", Main.frame.getWidth() / 2 - 145, Main.frame.getHeight() / 2 + 300);
        g.drawString("a.k.a Bracketology Experts", Main.frame.getWidth() / 2 - 180,Main.frame.getHeight() / 2 + 350);
        g.finalize();

        button = new JButton();
        button.setSize(110,30);
        button.setLocation( Main.frame.getWidth() / 2 - 50,Main.frame.getHeight() / 2 + 150);
        button.setVisible(true);
        button.enableInputMethods(true);
        button.setText("Color Key");
        Main.frame.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==button){
                    JFrame newf = new JFrame("Color Key:");
                    newf.setSize(500,200);
                    newf.setLocationRelativeTo(null);
                    newf.setVisible(true);
                    JLabel label = new JLabel();

                    label.setFont(new Font("Consolas", Font.BOLD, 22));
                    label.setText("<html>% Chance each team will win:      <BR>          Red: 55% >      <BR>       Yellow: 75% >       <BR>      Green: > 75%      </html>");
                    newf.add(label);

                }
            }
        });





    }

}
