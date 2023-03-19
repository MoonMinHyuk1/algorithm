import java.util.*;

class Rank implements Comparable<Rank> {
  public int a, b;

  public Rank(int a, int b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public int compareTo(Rank o) {
    if(this.a == o.a) {
      return this.b - o.b;
    } else {
      return this.a - o.a;
    }
  }
}

public class Main1946 {
  static ArrayList<Rank> arr;
  static int t, n;

  public int solution() {
    int answer = 0, min = Integer.MAX_VALUE;

    Collections.sort(arr);
    for(Rank rank : arr) {
      if(rank.b < min) {
        min = rank.b;
      } else {
        answer++;
      }
    }

    answer = n - answer;

    return answer;
  }

  public static void main(String[] args) {
    Main1946 A = new Main1946();
    Scanner sc = new Scanner(System.in);

    t = sc.nextInt();
    for(int i = 0; i < t; i++) {
      n = sc.nextInt();
      arr = new ArrayList<>();
      for(int j = 0; j < n; j++) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        arr.add(new Rank(a, b));
      }

      System.out.println(A.solution());
    }
  }
}