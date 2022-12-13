import java.util.*;
import java.io.*;

public class Main1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb.append(st.countTokens());
        System.out.println(sb);
    }
}