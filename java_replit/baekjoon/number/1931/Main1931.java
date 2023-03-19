import java.util.*;

public class Main1931 {
  public int solution(int n, int[][] arr) {
    int answer = 0;

    Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});

    int pTime = 0;
    for(int i = 0; i < n; i++) {
      if(pTime <= arr[i][0]) {
        pTime = arr[i][1];
        answer++;
      }
    }

    return answer;
  }
  
  public static void main(String[] args) {
    Main1931 A = new Main1931();
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[][] arr = new int[n][2];
    for(int i = 0; i < n; i++) {
      arr[i][0] = sc.nextInt();
      arr[i][1] = sc.nextInt();
    }
    System.out.println(A.solution(n, arr));
  }
}