import java.util.*;

public class Main1789 {
  public static void main(String[] args) {
    Main1789 A = new Main1789();
    Scanner sc = new Scanner(System.in);

    long s = sc.nextLong();
    long n = 0, sum = 0;
    for(long i = 1; i <= s; i++) {
      sum += i;
      n++;
      if(sum > s) {
        n--;
        break;
      } else if(sum == s) {
        break;
      }
    }
    System.out.println(n);
  }
}