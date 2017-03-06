import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ZTable {
    public static double ztable(double z) throws FileNotFoundException {
        if(z > 3){
            return 0;
        }
        else if(z < - 3){
            return 1;
        }
        double p;
        Scanner txt = new Scanner(new File("Z-Table.txt"));
        int format = (int) (Math.abs(z) * 1000);
        for(int i = 0; i < format / 100; i++){
            txt.nextLine();
        }
        int index  = format - (format / 100 * 100);
        index++;

        String[] zline = txt.nextLine().split(",");
        if(z >= 0) {
            p = 1 - Double.parseDouble(zline[index]);
        }
        else{
            p = Double.parseDouble(zline[index]);
        }
        return p;
    }
    public static double propp(double t1, double t2) throws FileNotFoundException {
        double std1 = Math.sqrt(t1*(1-t1)), std2 = Math.sqrt(t2*(1-t2));
        double z = (t2-t1) / Math.sqrt(((Math.pow(std1, 2) + Math.pow(std2, 2))));
        return ztable(z);
    }
    public static double sosp(double sos1, double sos2) throws FileNotFoundException {
        double std = .5;
        double z = (sos2 - sos1) /  std;

        return ztable(z);
    }
    public static double averagep(double p1, double p2){
        return (p1 + p2) / 2.0;
    }
}
