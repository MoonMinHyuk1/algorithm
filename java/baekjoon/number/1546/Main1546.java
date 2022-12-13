import java.util.*;
import java.io.*;

public class Main1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];
        double max = Integer.MIN_VALUE, sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        for(int i = 0; i < n; i++) {
            arr[i] = (arr[i] / max) * 100;
            sum += arr[i];
        }
        double avg = sum / n;

        bw.write(avg + "\n");
        bw.flush();
        bw.close();
    }
}