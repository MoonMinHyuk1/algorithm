import java.util.*;
import java.io.*;

public class Main1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        if(n >= 100) {
            cnt = 99;
        } else {
            cnt = n;
        }
        for(int i = 100; i <= n; i++) {
            int num = i;
            int last = num % 10;
            num = num / 10;
            int d = last - (num % 10);
            boolean check = true;
            while(num != 0) {
                if(d != (last - (num % 10))) {
                    check = false;
                    break;
                }
                last = num % 10;
                num = num / 10;
            }
            if(check == true) {
                cnt++;
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}