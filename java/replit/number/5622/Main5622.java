import java.util.*;
import java.io.*;

public class Main5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int answer = 0;
        for(char c : str.toCharArray()) {
            if(c == 'A' || c == 'B' || c == 'C') {
                answer += 3;
            } else if(c == 'D' || c == 'E' || c == 'F') {
                answer += 4;
            } else if(c == 'G' || c == 'H' || c == 'I') {
                answer += 5;
            } else if(c == 'J' || c == 'K' || c == 'L') {
                answer += 6;
            } else if(c == 'M' || c == 'N' || c == 'O') {
                answer += 7;
            } else if(c == 'P' || c == 'Q' || c == 'R' || c == 'S') {
                answer += 8;
            } else if(c == 'T' || c == 'U' || c == 'V') {
                answer += 9;
            } else if(c == 'W' || c == 'X' || c == 'Y' || c == 'Z') {
                answer += 10;
            }
        }

        System.out.println(answer);
    }
}