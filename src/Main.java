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
    public static String Winner;
    public static bracketFrame frame;
    public static void main(String[] args) throws IOException {
        Scanner test = new Scanner(new File("teams.txt"));
        System.out.println("ROUND OF 64");
        System.out.println();

        while(test.hasNextLine()){
            String s[] = test.nextLine().split(",");

            tm.add(s[0]);
            wl.add(Double.parseDouble(s[1]));
            SOS.add(Double.parseDouble(s[2]));

        }
        for(int i = 0; i < tm.size(); i = i + 2) {
            double Corrected1 = wl.get(i) * SOS.get(i), Corrected2 = wl.get(i + 1) * SOS.get(i + 1);
            System.out.println(tm.get(i) + "\t" + tm.get(i + 1) + ":\t" + ZTable.p(Corrected1, Corrected2));
            if(ZTable.p(Corrected1, Corrected2) >= .5){
                System.out.println(tm.get(i) +"\tWins!");
                RO32TM.add(tm.get(i));
                RO32NUM.add(wl.get(i));
                RO32SOS.add(SOS.get(i));

            }
            else{

                System.out.println(tm.get(i + 1) + "\tWins!");
                RO32TM.add(tm.get(i+1));
                RO32NUM.add(wl.get(i+1));
                RO32SOS.add(SOS.get(i + 1));

            }

            System.out.println();

        }

        System.out.println("\n\n\n");

        System.out.println("ROUND OF 32");
        for(int i = 0; i < RO32TM.size(); i = i + 2) {
            double Corrected1 = RO32NUM.get(i) * RO32SOS.get(i), Corrected2 = RO32NUM.get(i + 1) * RO32SOS.get(i + 1);
            System.out.println(RO32TM.get(i) + "\t" + RO32TM.get(i + 1) + ":\t" + ZTable.p(Corrected1, Corrected2));

            if(ZTable.p(Corrected1, Corrected2) >= .5){
                System.out.println(RO32TM.get(i) +"\tWins!");
                RO16TM.add(RO32TM.get(i));
                RO16NUM.add(RO32NUM.get(i));
                RO16SOS.add(RO32SOS.get(i));

            }
            else{
                System.out.println(RO32TM.get(i + 1) + "\tWins!");
                RO16TM.add(RO32TM.get(i+1));
                RO16NUM.add(RO32NUM.get(i+1));
                RO16SOS.add(RO32SOS.get(i + 1));

            }
            System.out.println();

        }
        System.out.println("\n\n\n");

        System.out.println("ROUND OF 16 (Sweet 16)");
        for(int i = 0; i < RO16TM.size(); i = i + 2) {
            double Corrected1 = RO16NUM.get(i) * RO16SOS.get(i), Corrected2 = RO16NUM.get(i + 1) * RO16SOS.get(i + 1);
            System.out.println(RO16TM.get(i) + "\t" + RO16TM.get(i + 1) + ":\t" + ZTable.p(Corrected1, Corrected2));
            if(ZTable.p(Corrected1, Corrected2) >= .5){
                System.out.println(RO16TM.get(i) +"\tWins!");
                RO8TM.add(RO16TM.get(i));
                RO8NUM.add(RO16NUM.get(i));
                RO8SOS.add(RO16SOS.get(i));
            }
            else{
                System.out.println(RO16TM.get(i + 1) + "\tWins!");
                RO8TM.add(RO16TM.get(i+1));
                RO8NUM.add(RO16NUM.get(i+1));
                RO8SOS.add(RO16SOS.get(i + 1));


            }
            System.out.println();

        }

        System.out.println("\n\n\n");

        System.out.println("ROUND OF 8 (Elite 8)");
        for(int i = 0; i < RO8TM.size(); i = i + 2) {
            double Corrected1 = RO8NUM.get(i) * RO8SOS.get(i), Corrected2 = RO8NUM.get(i + 1) * RO8SOS.get(i + 1);

            System.out.println(RO8TM.get(i) + "\t" + RO8TM.get(i + 1) + ":\t" + ZTable.p(RO8NUM.get(i), RO8NUM.get(i + 1)));
            if(ZTable.p(Corrected1, Corrected2) >= .5){
                System.out.println(RO8TM.get(i) +"\tWins!");
                RO4TM.add(RO8TM.get(i));
                RO4NUM.add(RO8NUM.get(i));
                RO4SOS.add(RO8SOS.get(i));

            }
            else{
                System.out.println(RO8TM.get(i + 1) + "\tWins!");
                RO4TM.add(RO8TM.get(i + 1));
                RO4NUM.add(RO8NUM.get(i + 1));
                RO4SOS.add(RO8SOS.get(i + 1));


            }
            System.out.println();

        }

        System.out.println("\n\n\n");

        System.out.println("ROUND OF 4 (Final 4)");
        for(int i = 0; i < RO4TM.size(); i = i + 2) {
            double Corrected1 = RO4NUM.get(i) * RO4SOS.get(i), Corrected2 = RO4NUM.get(i + 1) * RO4SOS.get(i + 1);
            System.out.println(RO4TM.get(i) + "\t" + RO4TM.get(i + 1) + ":\t" + ZTable.p(RO4NUM.get(i), RO4NUM.get(i + 1)));
            if(ZTable.p(Corrected1, Corrected2) >= .5){
                System.out.println(RO4TM.get(i) +"\tWins!");
                FinalTM.add(RO4TM.get(i));
                FinalNUM.add(RO4NUM.get(i));
                FinalSOS.add(RO4SOS.get(i));

            }
            else{
                System.out.println(RO4TM.get(i + 1) + "\tWins!");
                FinalTM.add(RO4TM.get(i + 1));
                FinalNUM.add(RO4NUM.get(i + 1));
                FinalSOS.add(RO4SOS.get(i + 1));


            }
            System.out.println();

        }
        System.out.println("\n\n\n");

        System.out.println("Championship");
        for(int i = 0; i < FinalTM.size(); i = i + 2) {
            double Corrected1 = FinalNUM.get(i) * FinalSOS.get(i), Corrected2 = FinalNUM.get(i + 1) * FinalSOS.get(i + 1);
            System.out.println(FinalTM.get(i) + "\t" + FinalTM.get(i + 1) + ":\t" + ZTable.p(FinalNUM.get(i), FinalNUM.get(i + 1)));
            if (ZTable.p(Corrected1, Corrected2) >= .5) {
                System.out.println(FinalTM.get(i) + "\tWins!");
                Winner = FinalTM.get(i);
                break;

            } else {
                System.out.println(FinalTM.get(i + 1) + "\tWins!");
                Winner = FinalTM.get(i);
                break;


            }

        }
        frame = new bracketFrame();
    }


}
