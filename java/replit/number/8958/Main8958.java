import java.util.*;
import java.io.*;

public class Main8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            int score = 0, check = 0;
            for(char c : str.toCharArray()) {
                if(c == 'O') {
                    check++;
                    score += check;
                } else if(c == 'X') {
                    check = 0;
                }
            }
            bw.write(score + "\n");
        }

        bw.flush();
        bw.close();
    }
}