import java.util.*;

public class Main6588 {
  public static void main(String[] args) {
    Main6588 A = new Main6588();
    Scanner sc = new Scanner(System.in);
    boolean[] isPrime = new boolean[1000001];

    for(int i = 2; i < isPrime.length; i++) {
      isPrime[i] = true;
    }
    for(int i = 2; i < isPrime.length; i++) {
      if(isPrime[i] == true) {
        for(int j = i * 2; j < isPrime.length; j = j + i) {
          isPrime[j] = false;
        }
      }
    }

    while(true) {
      int n = sc.nextInt();
      if(n == 0) {
        break;
      }
      boolean check = false;
      for(int i = n - 1; i >= 3; i = i - 2) {
        boolean prime = isPrime[i];
        if(prime) {
          int j = n - i;
          if(isPrime[j]) {
            System.out.println(n + " = " + j + " + " + i);
            check = true;
            break;
          }
        }
      }
      if(check == false) {
        System.out.println("Goldbach's conjecture is wrong.");
      }
    }
  }
}