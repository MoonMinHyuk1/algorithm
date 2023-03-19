import java.util.*;
import java.io.*;

public class Main10829 {
  static List<Long> answer;
  
  public static void DFS(long num) {
    if(num == 0) {
      return;
    }

    DFS(num / 2);
    answer.add(num % 2);
    // System.out.print(num % 2);
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    answer = new ArrayList<>();

    String str = br.readLine();
    long num = Long.parseLong(str);

    DFS(num);
    for(Long n : answer) {
      System.out.print(n);
    }
  }
}