import java.util.*;
import java.io.*;

public class Main2884 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str, " ");
    int hour = Integer.parseInt(st.nextToken());
    int min = Integer.parseInt(st.nextToken());

    min = min - 45;
    if(min < 0) {
      min = min + 60;
      hour = hour - 1;
      if(hour < 0) {
        hour = 23;
      }
    }

    System.out.println(hour + " " + min);
  }
}