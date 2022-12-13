import java.util.*;
import java.io.*;

public class Main10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int t = Integer.parseInt(str);

        for(int i = 0; i < t; i++) {
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(a + b);
        }
    }
}
