import java.util.*;

public class Main13305 {
  public long solution(long[] road, long[] city) {
    long answer = 0;
    long min = city[0];

    for(int i = 0; i < road.length; i++) {
      if(min > city[i]) {
        min = city[i];
      }
      answer += min * road[i];
    }

    return answer;
  }
  
  public static void main(String[] args) {
    Main13305 A = new Main13305();
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    long[] road = new long[n - 1];
    long[] city = new long[n];
    for(int i = 0; i < road.length; i++) {
      road[i] = sc.nextLong();
    }
    for(int i = 0; i < city.length; i++) {
      city[i] = sc.nextLong();
    }
    System.out.println(A.solution(road, city));
  }
}