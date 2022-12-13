package section6.lru4;

import java.util.Scanner;

public class Main {
    public int[] solution(int s, int n, int[] arr) {
        int[] answer = new int[s];

        for(int i = 0; i < n; i++) {
            boolean lru = false;
            for(int j = 0; j < s; j++) {
                if(answer[j] == arr[i]) {
                    int temp = answer[j];
                    for(int k = j - 1; k >= 0; k--) {
                        answer[k + 1] = answer[k];
                    }
                    answer[0] = temp;
                    lru = true;
                    break;
                }
            }
            if(lru == false) {
                for(int j = s - 2; j >= 0; j--) {
                    answer[j + 1] = answer[j];
                }
                answer[0] = arr[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int num : A.solution(s, n, arr)) {
            System.out.print(num + " ");
        }
    }
}
