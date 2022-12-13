import java.util.*;
import java.io.*;

public class Main2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            String p = "";
            for(char c : s.toCharArray()) {
                for(int j = 0; j < r; j++) {
                    p += c;
                }
            }
            sb.append(p + "\n");
//            bw.write(p + "\n");
        }

        System.out.print(sb);

//        bw.flush();
//        bw.close();
    }
}