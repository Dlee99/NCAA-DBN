import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ZTable {
    public static double ztable(double z) throws FileNotFoundException {
        if (z > 3) {
            return 0;
        } else if (z < -3) {
            return 1;
        }
        double p;
        Scanner txt = new Scanner(new File("Z-Table.txt"));
        int format = (int) (Math.abs(z) * 1000);
        for (int i = 0; i < format / 100; i++) {
            txt.nextLine();
        }
        int index = format - (format / 100 * 100);
        index++;

        String[] zline = txt.nextLine().split(",");
        if (z >= 0) {
            p = 1 - Double.parseDouble(zline[index]);
        } else {
            p = Double.parseDouble(zline[index]);
        }
        return p;
    }

    public static double propp(double t1, double t2) throws FileNotFoundException {
        double z1 = (t1 - 0.45204196477419) / 0.10838898449034;
        double z2 = (t2 - 0.45204196477419) / 0.10838898449034;
        return ztable(ztable(z1) - ztable(z2));
    }
}
