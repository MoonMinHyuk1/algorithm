import java.util.*;
import java.io.*;

public class Main10430 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str, " ");
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    System.out.println((a + b) % c);
    System.out.println(((a % c) + (b % c)) % c);
    System.out.println((a * b) % c);
    System.out.println(((a % c) * (b % c)) % c);
  }
}