import java.util.*;
import java.io.*;

public class Main2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 0, index = 0;
        for(int i = 0; i < 9; i++) {
            String str = br.readLine();
            int n = Integer.parseInt(str);
            if(n > max) {
                max = n;
                index = i + 1;
            }
        }

        bw.write(max + "\n" + index);
        bw.flush();
        bw.close();
    }
}