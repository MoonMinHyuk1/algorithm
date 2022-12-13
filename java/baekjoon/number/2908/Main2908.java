import java.util.*;
import java.io.*;

public class Main2908 {
    public static int translate(int n) {
        int t = 0;

        while(n != 0) {
            t *= 10;
            t += n % 10;
            n /= 10;
        }

        return t;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        a = translate(a);
        b = translate(b);

        if(a >= b) {
            sb.append(a);
        } else {
            sb.append(b);
        }

        System.out.println(sb);
    }
}