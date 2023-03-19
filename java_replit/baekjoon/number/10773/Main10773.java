import java.util.*;

public class Main10773 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int answer = 0;

    int n = sc.nextInt();
    List<Integer> arr = new ArrayList<>();
    for(int i = 0; i < n; i++) {
      int m = sc.nextInt();
      if(m == 0) {
        arr.remove(arr.size() - 1);
      } else {
        arr.add(m);
      }
    }
    for(Integer num : arr) {
      answer += num;
    }
    System.out.println(answer);
  }
}