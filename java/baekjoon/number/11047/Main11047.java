import java.util.*;

public class Main11047 {
  public int solution(int n, int k, int[] arr) {
    int answer = 0;

    for(int i = n - 1; i >= 0; i--) {
      if(k / arr[i] > 0) {
        answer += k / arr[i];
        k = k % arr[i];
      }
      if(k == 0) {
        break;
      }
    }

    return answer;
  }
  
  public static void main(String[] args) {
    Main11047 A = new Main11047();
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(A.solution(n, k, arr));
  }
}