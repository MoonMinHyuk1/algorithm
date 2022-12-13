import java.util.*;

public class Main5585 {
  static int n, answer = 0;

  public void solution(int coin) {
    if(n / coin > 0) {
      answer += n / coin;
      n = n % coin;
    }
  }
  
  public static void main(String[] args) {
    Main5585 A = new Main5585();
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    n = 1000 - n;
    A.solution(500);
    A.solution(100);
    A.solution(50);
    A.solution(10);
    A.solution(5);
    A.solution(1);
    System.out.println(answer);
  }
}