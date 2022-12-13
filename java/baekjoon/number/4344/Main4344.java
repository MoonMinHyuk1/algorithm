import java.util.*;
import java.io.*;

public class Main4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        for(int i = 0; i < c; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            double[] arr = new double[n];
            double sum = 0, avg;
            for(int j = 0; j < n; j++) {
                arr[j] = Double.parseDouble(st.nextToken());
                sum += arr[j];
            }
            avg = sum / n;
            double cnt = 0;
            for(int j = 0; j < n; j++) {
                if(avg < arr[j]) {
                    cnt++;
                }
            }
            double answer = cnt / n * 100;
            System.out.printf("%.3f%%\n", answer);
        }
    }
}