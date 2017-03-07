import java.io.*;
import java.util.*;

public class stats {

    public static void main(String[] args) throws IOException {
        FileWriter stats = new FileWriter(new File("stats.txt"));
        for(double wls = 1; wls < 5; wls = wls + .01){
            for(double soss = 1; soss < 5; soss = soss + .01){
                Main.wls = wls;
                Main.soss = soss;
                Scanner test = new Scanner(new File("teams.txt"));
                //Scanner test = new Scanner(new File("2015"));
                Main.tm.clear();
                Main.wl.clear();
                Main.SOS.clear();
                Main.RO32TM.clear();
                Main.RO32NUM.clear();
                Main.RO32SOS.clear();
                Main.RO16TM.clear();
                Main.RO16NUM.clear();
                Main.RO16SOS.clear();
                Main.RO8TM.clear();
                Main.RO8NUM.clear();
                Main.RO8SOS.clear();
                Main.RO4TM.clear();
                Main.RO4NUM.clear();
                Main.RO4SOS.clear();
                Main.FinalTM.clear();
                Main.FinalNUM.clear();
                Main.FinalSOS.clear();

                while (test.hasNextLine()) {
                    String s[] = test.nextLine().split(",");

                    Main.tm.add(s[0]);
                    Main.wl.add(Double.parseDouble(s[1]));
                    Main.SOS.add(Double.parseDouble(s[2]));


                }
                for (int i = 0; i < Main.tm.size(); i = i + 2) {
                    if (ZTable.averagep(ZTable.propp(Main.wl.get(i), Main.wl.get(i + 1)), ZTable.sosp(Main.SOS.get(i), Main.SOS.get(i + 1))) >= .5) {
                        Main.RO32TM.add(Main.tm.get(i));
                        Main.RO32NUM.add(Main.wl.get(i));
                        Main.RO32SOS.add(Main.SOS.get(i));


                    } else {


                        Main.RO32TM.add(Main.tm.get(i + 1));
                        Main.RO32NUM.add(Main.wl.get(i + 1));
                        Main.RO32SOS.add(Main.SOS.get(i + 1));

                    }


                }

                for (int i = 0; i < Main.RO32TM.size(); i = i + 2) {

                    if (ZTable.averagep(ZTable.propp(Main.RO32NUM.get(i), Main.RO32NUM.get(i + 1)), ZTable.sosp(Main.RO32SOS.get(i), Main.RO32SOS.get(i + 1))) >= .5) {
                        Main.RO16TM.add(Main.RO32TM.get(i));
                        Main.RO16NUM.add(Main.RO32NUM.get(i));
                        Main.RO16SOS.add(Main.RO32SOS.get(i));

                    } else {
                        Main.RO16TM.add(Main.RO32TM.get(i + 1));
                        Main.RO16NUM.add(Main.RO32NUM.get(i + 1));
                        Main.RO16SOS.add(Main.RO32SOS.get(i + 1));

                    }

                }

                for (int i = 0; i < Main.RO16TM.size(); i = i + 2) {
                    if (ZTable.averagep(ZTable.propp(Main.RO16NUM.get(i), Main.RO16NUM.get(i + 1)), ZTable.sosp(Main.RO16SOS.get(i), Main.RO16SOS.get(i + 1))) >= .5) {
                        Main.RO8TM.add(Main.RO16TM.get(i));
                        Main.RO8NUM.add(Main.RO16NUM.get(i));
                        Main.RO8SOS.add(Main.RO16SOS.get(i));
                    } else {
                        Main.RO8TM.add(Main.RO16TM.get(i + 1));
                        Main.RO8NUM.add(Main.RO16NUM.get(i + 1));
                        Main.RO8SOS.add(Main.RO16SOS.get(i + 1));

                    }

                }


                for (int i = 0; i < Main.RO8TM.size(); i = i + 2) {
                    if (ZTable.averagep(ZTable.propp(Main.RO8NUM.get(i), Main.RO8NUM.get(i + 1)), ZTable.sosp(Main.RO8SOS.get(i), Main.RO8SOS.get(i + 1))) >= .5) {

                        Main.RO4TM.add(Main.RO8TM.get(i));
                        Main.RO4NUM.add(Main.RO8NUM.get(i));
                        Main.RO4SOS.add(Main.RO8SOS.get(i));

                    } else {
                        Main.RO4TM.add(Main.RO8TM.get(i + 1));
                        Main.RO4NUM.add(Main.RO8NUM.get(i + 1));
                        Main.RO4SOS.add(Main.RO8SOS.get(i + 1));


                    }

                }

                for (int i = 0; i < Main.RO4TM.size(); i = i + 2) {

                    if (ZTable.averagep(ZTable.propp(Main.RO4NUM.get(i), Main.RO4NUM.get(i + 1)), ZTable.sosp(Main.RO4SOS.get(i), Main.RO4SOS.get(i + 1))) >= .5) {
                        Main.FinalTM.add(Main.RO4TM.get(i));
                        Main.FinalNUM.add(Main.RO4NUM.get(i));
                        Main.FinalSOS.add(Main.RO4SOS.get(i));

                    } else {
                        Main.FinalTM.add(Main.RO4TM.get(i + 1));
                        Main.FinalNUM.add(Main.RO4NUM.get(i + 1));
                        Main.FinalSOS.add(Main.RO4SOS.get(i + 1));


                    }

                }

                for (int i = 0; i < Main.FinalTM.size(); i = i + 2) {
                    if (ZTable.averagep(ZTable.propp(Main.FinalNUM.get(i), Main.FinalNUM.get(i + 1)), ZTable.sosp(Main.FinalSOS.get(i), Main.FinalSOS.get(i + 1))) >= .5) {
                        Main.Winner = Main.FinalTM.get(i);
                        break;

                    } else {
                        Main.Winner = Main.FinalTM.get(i);
                        break;


                    }

                }
                test.close();
                System.out.println(wls + "\t" + soss);
                stats.write(wls + "\t" + soss + ":\t" + right() + "\n");
            }
        }
        stats.close();
    }
    public static double right() throws FileNotFoundException {
        Scanner right = new Scanner(new File("Right.txt"));
        double sum = 0;
        for (int i = 0; i < Main.RO32TM.size(); i++) {
            if (right.nextLine().equals(Main.RO32TM.get(i))) {
                sum++;
            } else {

            }
        }
        for (int i = 0; i < Main.RO16TM.size(); i++) {
            if (right.nextLine().equals(Main.RO16TM.get(i))) {
                sum++;
            } else {

            }
        }
        for (int i = 0; i < Main.RO8TM.size(); i++) {
            if (right.nextLine().equals(Main.RO8TM.get(i))) {
                sum++;
            } else {

            }
        }
        for (int i = 0; i < Main.RO4TM.size(); i++) {
            if (right.nextLine().equals(Main.RO4TM.get(i))) {
                sum++;
            } else {

            }
        }
        for (int i = 0; i < Main.FinalTM.size(); i++) {
            if (right.nextLine().equals(Main.FinalTM.get(i))) {
                sum++;
            } else {

            }
        }
        if (right.nextLine().equals(Main.Winner))
            sum++;
        return sum / 63.0;
    }
}


