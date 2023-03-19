import java.util.*;

public class Main11399 {
  public int solution(int n, int[] arr) {
    int answer = 0;

    Arrays.sort(arr);
    for(int i = 0; i < arr.length; i++) {
      answer += arr[i] * n;
      n--;
    }

    return answer;
  }
  
  public static void main(String[] args) {
    Main11399 A = new Main11399();
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(A.solution(n, arr));
  }
}