import java.util.*;
import java.io.*;

public class Main2739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int n = Integer.parseInt(str);

        for(int i = 1; i <= 9; i++) {
            System.out.println(n + " * " + i + " = " + (n * i));
        }
    }
}