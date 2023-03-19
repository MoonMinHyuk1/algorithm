import java.util.*;
import java.io.*;

public class Main8393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int a = Integer.parseInt(str);
        int answer = 0;
        for(int i = 1; i <= a; i++) {
            answer += i;
        }
        System.out.println(answer);
    }
}