import java.util.*;

class Main2839 {
  public int solution(int n) {
    int answer = 0, temp;

    for(int i = n / 5; i >= 0 ; i--) {
      temp = n - (5 * i);
      answer = i;
      if(temp % 3 == 0) {
        answer += temp / 3;

        return answer;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    Main2839 A = new Main2839();
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    System.out.println(A.solution(n));
  }
}