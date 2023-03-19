import java.util.*;
import java.io.*;

public class Main10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            if(arr[i] < x) {
                bw.write(arr[i] + " ");
            }
        }

        bw.flush();
        bw.close();
    }
}