import java.util.*;
import java.io.*;

public class Main3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine()) % 42;
            if(!arr.contains(n)) {
                arr.add(n);
            }
        }

        bw.write(arr.size() + "\n");
        bw.flush();
        bw.close();
    }
}