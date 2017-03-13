import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {


    public static ArrayList<String> tm = new ArrayList<>();
    public static ArrayList<Double> wl = new ArrayList<>();
    public static ArrayList<Double> SOS = new ArrayList<>();
    public static ArrayList<String> RO32TM = new ArrayList<>();
    public static ArrayList<Double> RO32NUM = new ArrayList<>();
    public static ArrayList<Double> RO32SOS = new ArrayList<>();
    public static ArrayList<String> RO16TM = new ArrayList<>();
    public static ArrayList<Double> RO16NUM = new ArrayList<>();
    public static ArrayList<Double> RO16SOS = new ArrayList<>();
    public static ArrayList<String> RO8TM = new ArrayList<>();
    public static ArrayList<Double> RO8NUM = new ArrayList<>();
    public static ArrayList<Double> RO8SOS = new ArrayList<>();
    public static ArrayList<String> RO4TM = new ArrayList<>();
    public static ArrayList<Double> RO4NUM = new ArrayList<>();
    public static ArrayList<Double> RO4SOS = new ArrayList<>();
    public static ArrayList<String> FinalTM = new ArrayList<>();
    public static ArrayList<Double> FinalNUM = new ArrayList<>();
    public static ArrayList<Double> FinalSOS = new ArrayList<>();
    public static ArrayList<Integer> rank64 = new ArrayList<>();
    public static ArrayList<Integer> rank32 = new ArrayList<>();
    public static ArrayList<Integer> rank16 = new ArrayList<>();
    public static ArrayList<Integer> rank8 = new ArrayList<>();
    public static ArrayList<Integer> rank4 = new ArrayList<>();
    public static ArrayList<Integer> rank2 = new ArrayList<>();
    public static ArrayList<Integer> rankWinner = new ArrayList<>();
    public static ArrayList<Color> RO64Color = new ArrayList<>();
    public static ArrayList<Color> RO32Color = new ArrayList<>();
    public static ArrayList<Color> RO16Color = new ArrayList<>();
    public static ArrayList<Color> RO8Color = new ArrayList<>();
    public static ArrayList<Color> RO4Color = new ArrayList<>();
    public static ArrayList<Color> FinalColor = new ArrayList<>();
    public static ArrayList<Double> offense = new ArrayList<>();
    public static ArrayList<Double> deffense = new ArrayList<>();
    public static ArrayList<Double> freeThrows = new ArrayList<>();
    public static ArrayList<Double> freeThrows32 = new ArrayList<>();
    public static ArrayList<Double> freeThrows16 = new ArrayList<>();
    public static ArrayList<Double> freeThrows8 = new ArrayList<>();
    public static ArrayList<Double> freeThrows4 = new ArrayList<>();
    public static ArrayList<Double> freeThrows2 = new ArrayList<>();
    public static double wls = 3;
    public static double soss = 1.5;
    public static String Winner;
    public static bracketFrame frame;

    public static void main(String[] args) throws IOException {
        Scanner test = new Scanner(new File("teams.txt"));
        //Scanner test = new Scanner(new File("2015"));
        System.out.println("ROUND OF 64");
        System.out.println();

        while (test.hasNextLine()) {
            String s[] = test.nextLine().split(",");

            tm.add(s[0]);
            wl.add(Double.parseDouble(s[1]));
            SOS.add(Double.parseDouble(s[2]));
            rank64.add(Integer.parseInt(s[3]));
            offense.add(Double.parseDouble(s[4]));
            deffense.add(Double.parseDouble(s[5]));


        }
        for (int i = 0; i < tm.size(); i = i + 2) {
            double Corrected1 = (wl.get(i) * SOS.get(i)*offense.get(i))/deffense.get(i), Corrected2 = (wl.get(i + 1) * SOS.get(i + 1)*offense.get(i+1))/deffense.get(i+1);
            System.out.println(tm.get(i) + "\t" + tm.get(i + 1) + ":\t" + ZTable.propp(Corrected1, Corrected2));
            if (ZTable.propp(Corrected1, Corrected2) >= .5) {
                System.out.println(tm.get(i) + "\tWins!");
                RO32TM.add(tm.get(i));
                RO32NUM.add(wl.get(i));
                RO32SOS.add(SOS.get(i));
                rank32.add(rank64.get(i));
          


            } else {

                System.out.println(tm.get(i + 1) + "\tWins!");
                RO32TM.add(tm.get(i + 1));
                RO32NUM.add(wl.get(i + 1));
                RO32SOS.add(SOS.get(i + 1));
                rank32.add(rank64.get(i+1));

            }
            if(ZTable.propp(Corrected1, Corrected2) > .45 && ZTable.propp(Corrected1, Corrected2) < .55)
                RO64Color.add(Color.RED);
            else if (ZTable.propp(Corrected1, Corrected2) > .25 && ZTable.propp(Corrected1, Corrected2) < .75)
                RO64Color.add(Color.YELLOW);
            else
                RO64Color.add(Color.GREEN);

            System.out.println();

        }

        System.out.println("\n\n\n");

        System.out.println("ROUND OF 32");
        for (int i = 0; i < RO32TM.size(); i = i + 2) {
            double Corrected1 = RO32NUM.get(i) * RO32SOS.get(i), Corrected2 = RO32NUM.get(i + 1) * RO32SOS.get(i + 1);
            System.out.println(RO32TM.get(i) + "\t" + RO32TM.get(i + 1) + ":\t" + ZTable.propp(Corrected1, Corrected2));

            if (ZTable.propp(Corrected1, Corrected2) >= .5) {
                System.out.println(RO32TM.get(i) + "\tWins!");
                RO16TM.add(RO32TM.get(i));
                RO16NUM.add(RO32NUM.get(i));
                RO16SOS.add(RO32SOS.get(i));
                rank16.add(rank32.get(i));

            } else {
                System.out.println(RO32TM.get(i + 1) + "\tWins!");
                RO16TM.add(RO32TM.get(i + 1));
                RO16NUM.add(RO32NUM.get(i + 1));
                RO16SOS.add(RO32SOS.get(i + 1));
                rank16.add(rank32.get(i+1));

            }
            if(ZTable.propp(Corrected1, Corrected2) > .45 && ZTable.propp(Corrected1, Corrected2) < .55)
                RO32Color.add(Color.RED);
            else if (ZTable.propp(Corrected1, Corrected2) > .25 && ZTable.propp(Corrected1, Corrected2) < .75)
                RO32Color.add(Color.ORANGE);
            else
                RO32Color.add(Color.GREEN);
           
            System.out.println();

        }
        System.out.println("\n\n\n");

        System.out.println("ROUND OF 16 (Sweet 16)");
        for (int i = 0; i < RO16TM.size(); i = i + 2) {
            double Corrected1 = RO16NUM.get(i) * RO16SOS.get(i), Corrected2 = RO16NUM.get(i + 1) * RO16SOS.get(i + 1);
            System.out.println(RO16TM.get(i) + "\t" + RO16TM.get(i + 1) + ":\t" + ZTable.propp(Corrected1, Corrected2));
            if (ZTable.propp(Corrected1, Corrected2) >= .5) {
                System.out.println(RO16TM.get(i) + "\tWins!");
                RO8TM.add(RO16TM.get(i));
                RO8NUM.add(RO16NUM.get(i));
                RO8SOS.add(RO16SOS.get(i));
                rank8.add(rank16.get(i));
            } else {
                System.out.println(RO16TM.get(i + 1) + "\tWins!");
                RO8TM.add(RO16TM.get(i + 1));
                RO8NUM.add(RO16NUM.get(i + 1));
                RO8SOS.add(RO16SOS.get(i + 1));
                rank8.add(rank16.get(i+1));

            }
            if(ZTable.propp(Corrected1, Corrected2) > .45 && ZTable.propp(Corrected1, Corrected2) < .55)
                RO16Color.add(Color.RED);
            else if (ZTable.propp(Corrected1, Corrected2) > .25 && ZTable.propp(Corrected1, Corrected2) < .75)
                RO16Color.add(Color.ORANGE);
            else
                RO16Color.add(Color.GREEN);
            System.out.println();

        }

        System.out.println("\n\n\n");

        System.out.println("ROUND OF 8 (Elite 8)");
        for (int i = 0; i < RO8TM.size(); i = i + 2) {
            double Corrected1 = RO8NUM.get(i) * RO8SOS.get(i), Corrected2 = RO8NUM.get(i + 1) * RO8SOS.get(i + 1);

            System.out.println(RO8TM.get(i) + "\t" + RO8TM.get(i + 1) + ":\t" + ZTable.propp(Corrected1, Corrected2));
            if (ZTable.propp(Corrected1, Corrected2) >= .5) {
                System.out.println(RO8TM.get(i) + "\tWins!");
                RO4TM.add(RO8TM.get(i));
                RO4NUM.add(RO8NUM.get(i));
                RO4SOS.add(RO8SOS.get(i));
                rank4.add(rank8.get(i));

            } else {
                System.out.println(RO8TM.get(i + 1) + "\tWins!");
                RO4TM.add(RO8TM.get(i + 1));
                RO4NUM.add(RO8NUM.get(i + 1));
                RO4SOS.add(RO8SOS.get(i + 1));
                rank4.add(rank8.get(i+1));


            }
            if(ZTable.propp(Corrected1, Corrected2) > .45 && ZTable.propp(Corrected1, Corrected2) < .55)
                RO8Color.add(Color.RED);
            else if (ZTable.propp(Corrected1, Corrected2) > .25 && ZTable.propp(Corrected1, Corrected2) < .75)
                RO8Color.add(Color.ORANGE);
            else
                RO8Color.add(Color.GREEN);
            System.out.println();

        }

        System.out.println("\n\n\n");

        System.out.println("ROUND OF 4 (Final 4)");
        for (int i = 0; i < RO4TM.size(); i = i + 2) {
            double Corrected1 = RO4NUM.get(i) * RO4SOS.get(i), Corrected2 = RO4NUM.get(i + 1) * RO4SOS.get(i + 1);
            System.out.println(RO4TM.get(i) + "\t" + RO4TM.get(i + 1) + ":\t" + ZTable.propp(Corrected1, Corrected2));
            if (ZTable.propp(Corrected1, Corrected2) >= .5) {
                System.out.println(RO4TM.get(i) + "\tWins!");
                FinalTM.add(RO4TM.get(i));
                FinalNUM.add(RO4NUM.get(i));
                FinalSOS.add(RO4SOS.get(i));
                rank2.add(rank4.get(i));

            } else {
                System.out.println(RO4TM.get(i + 1) + "\tWins!");
                FinalTM.add(RO4TM.get(i + 1));
                FinalNUM.add(RO4NUM.get(i + 1));
                FinalSOS.add(RO4SOS.get(i + 1));
                rank2.add(rank4.get(i+1));


            }
            if(ZTable.propp(Corrected1, Corrected2) > .45 && ZTable.propp(Corrected1, Corrected2) < .55)
                RO4Color.add(Color.RED);
            else if (ZTable.propp(Corrected1, Corrected2) > .25 && ZTable.propp(Corrected1, Corrected2) < .75)
                RO4Color.add(Color.ORANGE);
            else
                RO4Color.add(Color.GREEN);
            System.out.println();

        }
        System.out.println("\n\n\n");

        System.out.println("Championship");
        for (int i = 0; i < FinalTM.size(); i = i + 2) {
            double Corrected1 = FinalNUM.get(i) * FinalSOS.get(i), Corrected2 = FinalNUM.get(i + 1) * FinalSOS.get(i + 1);
            System.out.println(FinalTM.get(i) + "\t" + FinalTM.get(i + 1) + ":\t" + ZTable.propp(Corrected1, Corrected2));
            if (ZTable.propp(Corrected1, Corrected2) >= .5) {
                System.out.println(FinalTM.get(i) + "\tWins!");
                Winner = FinalTM.get(i);
                rankWinner.add(rank64.get(i));

            } else {
                System.out.println(FinalTM.get(i + 1) + "\tWins!");
                Winner = FinalTM.get(i);
                rankWinner.add(rank64.get(i+1));
            }
            if(ZTable.propp(Corrected1, Corrected2) > .45 && ZTable.propp(Corrected1, Corrected2) < .55)
                FinalColor.add(Color.RED);
            else if (ZTable.propp(Corrected1, Corrected2) > .25 && ZTable.propp(Corrected1, Corrected2) < .75)
                FinalColor.add(Color.ORANGE);
            else
                FinalColor.add(Color.GREEN);

        }System.out.println(right());
        frame = new bracketFrame();
    }
    public static double right() throws FileNotFoundException {
        Scanner right = new Scanner(new File("Right.txt"));
        double sum = 0;
        for (int i = 0; i < RO32TM.size(); i++) {
            if (right.nextLine().equals(RO32TM.get(i))) {
                sum++;
            } else {

            }
        }
        for (int i = 0; i < RO16TM.size(); i++) {
            if (right.nextLine().equals(RO16TM.get(i))) {
                sum++;
            } else {

            }
        }
        for (int i = 0; i < RO8TM.size(); i++) {
            if (right.nextLine().equals(RO8TM.get(i))) {
                sum++;
            } else {

            }
        }
        for (int i = 0; i < RO4TM.size(); i++) {
            if (right.nextLine().equals(RO4TM.get(i))) {
                sum++;
            } else {

            }
        }
        for (int i = 0; i < FinalTM.size(); i++) {
            if (right.nextLine().equals(FinalTM.get(i))) {
                sum++;
            } else {

            }
        }
        if (right.nextLine().equals(Winner))
            sum++;
        return sum / 63.0;
    }
}


