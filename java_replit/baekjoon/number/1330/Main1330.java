import java.util.*;
import java.io.*;

public class Main1330 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(a > b) {
            System.out.println(">");
        } else if(a < b) {
            System.out.println("<");
        } else if(a == b) {
            System.out.println("==");
        }
    }
}