package section6.musicvideo9;

import java.util.Scanner;

public class Main {
    public int count(int cap, int[] arr) {
        int cnt = 1, sum = 0;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum > cap) {
                cnt++;
                sum = arr[i];
            }
        }

        return cnt;
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0, lt = arr[0], rt = 0;

        for(int i = 0; i < n; i++) {
            if(lt < arr[i]) {
                lt = arr[i];
            }
            rt += arr[i];
        }
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            int cnt = count(mid, arr);
            if(cnt <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
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
