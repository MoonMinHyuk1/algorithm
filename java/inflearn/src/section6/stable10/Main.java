package section6.stable10;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public boolean count(int maxLen, int c, int[] arr) {
        boolean check = false;
        int index = 0, cnt = 1;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - arr[index] >= maxLen) {
                index = i;
                cnt++;
            }
        }
        if(cnt >= c) {
            check = true;
        }

        return check;
    }

    public int solution(int n, int c, int[] arr) {
        int answer = 0, lt, rt;

        Arrays.sort(arr);
        lt = 1;
        rt = arr[arr.length - 1] - arr[0];
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(count(mid, c, arr)) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(A.solution(n, c, arr));
    }
}
