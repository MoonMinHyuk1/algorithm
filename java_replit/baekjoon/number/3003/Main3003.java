import java.util.*;
import java.io.*;

public class Main3003 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str, " ");
    int[] arr = new int[6];
    int[] nor = {1, 1, 2, 2, 2, 8};
    for(int i = 0; i < 6; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    for(int i = 0; i < arr.length; i++) {
      System.out.print(nor[i] - arr[i] + " ");
    }
  }
}