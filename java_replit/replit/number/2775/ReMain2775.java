import java.util.*;
import java.io.*;

public class ReMain2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] arr = new int[15][15];
        for(int i = 0; i < 15; i++) {
            arr[0][i] = i + 1;
            arr[i][0] = 1;
        }
        for(int i = 1; i < 15; i++) {
            for(int j = 1; j < 15; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(arr[k][n - 1] + "\n");
        }

        System.out.println(sb);
    }
}
