package section6.binarysearch8;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;

        Arrays.sort(arr);
        int lt = 0, rt = n - 1;
        while(true) {
            int pos = (lt + rt) / 2;
            if(arr[pos] == m) {
                answer = pos + 1;
                break;
            } else if(arr[pos] > m) {
                rt = pos - 1;
            } else if(arr[pos] < m) {
                lt = pos + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(A.solution(n, m, arr));
    }
}
