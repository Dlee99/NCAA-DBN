import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ZTable {
    public static double p(double t1, double t2) throws FileNotFoundException {
        double std1 = Math.sqrt(t1*(1-t1)), std2 = Math.sqrt(t2*1-t2);
        double z = (t2-t1) / (Math.sqrt(std1) + Math.sqrt(Math.exp(std2)));
        System.out.println(z);
        return ztable(z);
    }
    public static double ztable(double z) throws FileNotFoundException {
        double p;
        Scanner txt = new Scanner(new File("Z-Table.txt"));
        int format = (int) (Math.abs(z) * 100);
        for(int i = 0; i <= format / 10; i++){
            txt.nextLine();
        }
        String[] zline = txt.nextLine().split(",");
        if(z >= 0) {
            p = 1 - Double.parseDouble(zline[(format - ((format / 10)) * 10) + 1]);
        }
        else{
            p = Double.parseDouble(zline[(format - ((format / 10)) * 10) + 1]);
        }
        return p;
    }
}
