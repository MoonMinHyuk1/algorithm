import java.util.*;

public class Main2217 {
  public int solution(Integer[] arr) {
    int answer = 0, sum = 0;

    Arrays.sort(arr, Collections.reverseOrder());
    answer = sum = arr[0];
    for(int i = 1; i < arr.length; i++) {
      sum = arr[i] * (i + 1);
      answer = Math.max(answer, sum);
    }

    return answer;
  }
  
  public static void main(String[] args) {
    Main2217 A = new Main2217();
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    Integer[] arr = new Integer[n];
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(A.solution(arr));
  }
}