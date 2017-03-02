import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ZTable {
    public static double p(double t1, double t2) throws FileNotFoundException {
        double std1 = Math.sqrt(t1*(1-t1)), std2 = Math.sqrt(t2*1-t2);
        double z = (t1-t2) / (Math.sqrt(std1) + Math.sqrt(Math.exp(std2)));
        return ztable(z);
    }
    public static double ztable(double z) throws FileNotFoundException {
        double p = .5;
        Scanner txt = new Scanner(new File("Z-Table.txt"));
        int format = (int) (z * 100);
        z = (double) format / 100;
        for(int i = 0; )
        return p;
    }
}
