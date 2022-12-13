import java.util.*;

public class Main9095 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];
    int[] ch = new int[11];
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    ch[1] = 1;
    ch[2] = 2;
    ch[3] = 4;
    for(int i = 4; i < 11; i++) {
      ch[i] = ch[i - 1] + ch[i - 2] + ch[i - 3];
    }
    for(int i = 0; i < n; i++) {
      System.out.println(ch[arr[i]]);
    }
  }
}