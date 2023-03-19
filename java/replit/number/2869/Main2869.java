import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main2869 {
  public static void main(String[] args) throws IOException {
    Main2869 A = new Main2869();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int answer = 0;

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int v = Integer.parseInt(st.nextToken());

    answer = (v - b) / (a - b);
    if((v - b) % (a - b) != 0) {
      answer++;
    }
    
    System.out.println(answer);
  }
}