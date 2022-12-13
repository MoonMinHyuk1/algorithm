import java.util.*;
import java.io.*;

public class Main2588 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    int a = Integer.parseInt(str);
    str = br.readLine();
    int b = Integer.parseInt(str);

    int answer = 0;
    int cnt = 1;
    while(b != 0) {
      int c = b % 10;
      b = b / 10;
      System.out.println(a * c);
      answer += a * c * cnt;
      cnt *= 10;
    }
    System.out.println(answer);
  }
}