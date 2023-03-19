import java.util.*;

public class Main1541 {
  public static void main(String[] args) {
    Main1541 A = new Main1541();
    Scanner sc = new Scanner(System.in);

    int answer = 0;
    String str = sc.nextLine();
    String[] minus = str.split("-");

    for(int i = 0; i < minus.length; i++) {
      String[] plus = minus[i].split("\\+");
      int sum = 0;
      for(int j = 0; j < plus.length; j++) {
        sum += Integer.parseInt(plus[j]);
      }
      if(i == 0) {
        answer += sum;
      } else {
        answer -= sum;
      }
    }

    System.out.println(answer);
  }
}