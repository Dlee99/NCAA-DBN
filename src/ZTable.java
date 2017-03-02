import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ZTable {
    public static double ztable(double z) throws FileNotFoundException {
        double p = .5;
        Scanner txt = new Scanner(new File("Z-Table.txt"));
        int format = (int) (z * 100);
        z = (double) format / 100;

        return p;
    }
}
