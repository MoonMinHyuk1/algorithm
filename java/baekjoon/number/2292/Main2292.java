import java.util.*;
import java.io.*;

public class Main2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int start = 0, answer = 0;
        for(int i = 1;; i = i + (start * 6)) {
            answer++;
            start++;
            if(i >= n) {
                break;
            }
        }

        System.out.println(answer);
    }
}