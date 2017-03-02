import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        // write your code here
        ArrayList<String> tm = new ArrayList<>();
        ArrayList<Double> wl = new ArrayList<>();
        ArrayList<Double> SOS = new ArrayList<>();
        ArrayList<String> RO32TM = new ArrayList<>();
        ArrayList<Double> RO32NUM = new ArrayList<>();
        ArrayList<String> RO16TM = new ArrayList<>();
        ArrayList<Double> RO16NUM = new ArrayList<>();
        ArrayList<String> RO8TM = new ArrayList<>();
        ArrayList<Double> RO8NUM = new ArrayList<>();
        ArrayList<String> RO4TM = new ArrayList<>();
        ArrayList<Double> RO4NUM = new ArrayList<>();
        ArrayList<String> FinalTM = new ArrayList<>();
        ArrayList<Double> FinalNum = new ArrayList<>();

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

            }
            else{
                System.out.println(tm.get(i + 1) + "\tWins!");
                RO32TM.add(tm.get(i+1));
                RO32NUM.add(wl.get(i+1));


            }
            System.out.println();

        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("ROUND OF 32");
        for(int i = 0; i < RO32TM.size(); i = i + 2) {
            double Corrected1 = wl.get(i) * SOS.get(i), Corrected2 = wl.get(i + 1) * SOS.get(i + 1);
            System.out.println(RO32TM.get(i) + "\t" + RO32TM.get(i + 1) + ":\t" + ZTable.p(RO32NUM.get(i), RO32NUM.get(i + 1)));
            if(ZTable.p(Corrected1, Corrected2) >= .5){
                System.out.println(RO32TM.get(i) +"\tWins!");
                RO16TM.add(RO32TM.get(i));
                RO16NUM.add(RO32NUM.get(i));

            }
            else{
                System.out.println(RO32TM.get(i + 1) + "\tWins!");
                RO16TM.add(RO32TM.get(i+1));
                RO16NUM.add(RO32NUM.get(i+1));
//

            }
            System.out.println();

        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("ROUND OF 16 (Sweet 16)");
        for(int i = 0; i < RO16TM.size(); i = i + 2) {
            double Corrected1 = wl.get(i) * SOS.get(i), Corrected2 = wl.get(i + 1) * SOS.get(i + 1);
            System.out.println(RO16TM.get(i) + "\t" + RO16TM.get(i + 1) + ":\t" + ZTable.p(RO16NUM.get(i), RO16NUM.get(i + 1)));
            if(ZTable.p(Corrected1, Corrected2) >= .5){
                System.out.println(RO16TM.get(i) +"\tWins!");
                RO8TM.add(RO16TM.get(i));
                RO8NUM.add(RO16NUM.get(i));

            }
            else{
                System.out.println(RO16TM.get(i + 1) + "\tWins!");
                RO8TM.add(RO16TM.get(i+1));
                RO8NUM.add(RO16NUM.get(i+1));
//

            }
            System.out.println();

        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("ROUND OF 8 (Elite 8)");
        for(int i = 0; i < RO8TM.size(); i = i + 2) {
            double Corrected1 = wl.get(i) * SOS.get(i), Corrected2 = wl.get(i + 1) * SOS.get(i + 1);

            System.out.println(RO8TM.get(i) + "\t" + RO8TM.get(i + 1) + ":\t" + ZTable.p(RO8NUM.get(i), RO8NUM.get(i + 1)));
            if(ZTable.p(Corrected1, Corrected2) >= .5){
                System.out.println(RO8TM.get(i) +"\tWins!");
                RO4TM.add(RO8TM.get(i));
                RO4NUM.add(RO8NUM.get(i));

            }
            else{
                System.out.println(RO8TM.get(i + 1) + "\tWins!");
                RO4TM.add(RO8TM.get(i));
                RO4NUM.add(RO8NUM.get(i));
//

            }
            System.out.println();

        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("ROUND OF 4 (Final 4)");
        for(int i = 0; i < RO4TM.size(); i = i + 2) {
            double Corrected1 = wl.get(i) * SOS.get(i), Corrected2 = wl.get(i + 1) * SOS.get(i + 1);
            System.out.println(RO4TM.get(i) + "\t" + RO4TM.get(i + 1) + ":\t" + ZTable.p(RO4NUM.get(i), RO4NUM.get(i + 1)));
            if(ZTable.p(Corrected1, Corrected2) >= .5){
                System.out.println(RO4TM.get(i) +"\tWins!");
                FinalTM.add(RO4TM.get(i));
                FinalNum.add(RO4NUM.get(i));

            }
            else{
                System.out.println(RO4TM.get(i + 1) + "\tWins!");
                FinalTM.add(RO4TM.get(i));
                FinalNum.add(RO4NUM.get(i));
//

            }
            System.out.println();

        } System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Championship");
        for(int i = 0; i < FinalTM.size(); i = i + 2) {
            double Corrected1 = wl.get(i) * SOS.get(i), Corrected2 = wl.get(i + 1) * SOS.get(i + 1);
            System.out.println(FinalTM.get(i) + "\t" + FinalTM.get(i + 1) + ":\t" + ZTable.p(FinalNum.get(i), FinalNum.get(i + 1)));
            if(ZTable.p(Corrected1, Corrected2) >= .5){
                System.out.println(FinalTM.get(i) +"\tWins!");
                break;

            } else{
                System.out.println(FinalTM.get(i + 1) + "\tWins!");
                break;
//

            }

        }


    }


}
