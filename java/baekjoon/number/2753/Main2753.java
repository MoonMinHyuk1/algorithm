import java.util.*;
import java.io.*;

public class Main2753 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    int year = Integer.parseInt(str);
    int answer = 0;

    if(year % 4 == 0) {
      answer = 1;
      if(year % 100 == 0) {
        answer = 0;
        if(year % 400 == 0) {
          answer = 1;
        }
      }
    }

    System.out.println(answer);
  }
}