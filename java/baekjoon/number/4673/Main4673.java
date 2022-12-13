import java.util.*;
import java.io.*;

public class Main4673 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> arr = new ArrayList<>();

        for(int i = 1; i <= 10000; i++) {
            int n = i, sum = 0;
            while(n != 0) {
                sum += n % 10;
                n = n / 10;
            }
            if(sum + i <= 10000) {
                arr.add(sum + i);
            }
            if(!arr.contains(i)) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}