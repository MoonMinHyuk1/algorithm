import java.util.*;

class Main1110 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int temp = n, temp2;
    int cnt = 1;

    while(true) {
      if(temp >= 10) {
        temp2 = temp / 10 + temp % 10;
      } else {
        temp2 = temp;
      }
      temp = ((temp % 10) * 10) + (temp2 % 10);
      if(temp == n) {
        break;
      }
      cnt++;
    }

    System.out.println(cnt);
  }
}