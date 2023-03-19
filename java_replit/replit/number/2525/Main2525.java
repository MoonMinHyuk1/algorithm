import java.util.*;

class Main2525 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int hour = sc.nextInt();
    int min = sc.nextInt();
    int min2 = sc.nextInt();

    min += min2;
    hour += min / 60;
    min = min % 60;
    if(hour >= 24) {
      hour -= 24;
    }
    System.out.println(hour + " " + min);
  }
}