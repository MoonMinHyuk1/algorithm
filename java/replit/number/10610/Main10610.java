import java.util.*;

public class Main10610 {
  static String str;
  static Integer[] arr;

  public void solution() {
    boolean check = false;
    int sum = 0, index = 0;
    arr = new Integer[str.length()];

    for(char c : str.toCharArray()) {
      int n = c - '0';
      if(n == 0) {
        check = true;
      }
      sum += n;
      arr[index] = n;
      index++;
    }
    if((sum % 3 == 0) && (check == true)) {
      Arrays.sort(arr, Collections.reverseOrder());
      for(Integer n : arr) {
        System.out.print(n);
      }
    } else {
      System.out.println(-1);
    }
  }

  public static void main(String[] args) {
    Main10610 A = new Main10610();
    Scanner sc = new Scanner(System.in);

    str = sc.nextLine();
    A.solution();
  }
}