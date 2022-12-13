import java.util.*;
import java.io.*;

public class Main10817 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    List<Integer> arr = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(str, " ");

    arr.add(Integer.parseInt(st.nextToken()));
    arr.add(Integer.parseInt(st.nextToken()));
    arr.add(Integer.parseInt(st.nextToken()));
    Collections.sort(arr);

    System.out.println(arr.get(1));
  }
}