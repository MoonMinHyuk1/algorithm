import java.util.*;
import java.io.*;

public class Main2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int n = a * b * c;
        int[] arr = new int[10];
        while(n != 0) {
            arr[n % 10]++;
            n = n / 10;
        }

        for(int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}