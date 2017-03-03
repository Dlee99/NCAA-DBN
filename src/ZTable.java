import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ZTable {
    public static double p(double t1, double t2) throws FileNotFoundException {
        double std1 = Math.sqrt(t1*(1-t1)), std2 = Math.sqrt(t2*1-t2);
        double z = (t2-t1) / (Math.sqrt(std1) + Math.sqrt(Math.exp(std2)));
        return ztable(z);
    }
    public static double ztable(double z) throws FileNotFoundException {
        if(z > 3){
            return 1;
        }
        else if(z < -
            return 0;
        }
        double p;
        Scanner txt = new Scanner(new File("Z-Table.txt"));
        int format = (int) (Math.abs(z) * 1000);
        for(int i = 0; i < format / 100; i++){
            txt.nextLine();
        }
       intindex  = format - (format / 1000 * 1000);
        index = index - (index / 100 * 100);
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
}
