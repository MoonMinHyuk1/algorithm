import java.util.*;
import java.io.*;

public class Main10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            boolean[][] arr = new boolean[h][w];
            int cnt = 0;
            for(int j = 0; j < w; j++) {
                for(int k = 0; k < h; k++) {
                    cnt++;
                    if(cnt == n) {
                        if((j + 1) < 10) {
                            sb.append((k + 1) + "0" + (j + 1));
                        } else {
                            sb.append((k + 1) + "" + (j + 1));
                        }
                        break;
                    }
                }
                if(cnt == n) {
                    break;
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}