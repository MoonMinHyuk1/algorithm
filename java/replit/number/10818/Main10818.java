import java.util.*;
import java.io.*;

public class Main10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int n = Integer.parseInt(str);
        int[] arr = new int[n];
        str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        bw.write(arr[0] + " " + arr[n - 1]);
        bw.flush();
        bw.close();
    }
}