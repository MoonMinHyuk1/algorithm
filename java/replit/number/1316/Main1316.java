import java.util.*;
import java.io.*;

public class Main1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            int[] arr = new int[26];
            boolean check = true;
            arr[str.charAt(0) - 'a']++;
            for(int j = 1; j < str.length(); j++) {
                if(str.charAt(j) == str.charAt(j - 1)) {
                    arr[str.charAt(j) - 'a']++;
                } else {
                    if(arr[str.charAt(j) - 'a'] == 0) {
                        arr[str.charAt(j) - 'a']++;
                    } else {
                        check = false;
                        break;
                    }
                }
            }
            if(check == true) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}