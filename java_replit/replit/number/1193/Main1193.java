import java.util.*;
import java.io.*;

public class Main1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int start = 1, d = 1;
        for(int i = 1;; i = i + d) {
            d++;
            start++;
            if(i >= n) {
                break;
            }
        }
        int num = n;
        for(int i = 1; i <= num; i++) {
            if(num - i <= 0) {
                break;
            }
            num = num - i;
        }
        if(start % 2 == 0) {
            System.out.println((start - num) + "/" + num);
        } else {
            System.out.println(num + "/" + (start - num));
        }
    }
}