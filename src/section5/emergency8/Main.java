package section5.emergency8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(Integer num : arr) {
            queue.offer(num);
        }
        while(!queue.isEmpty()) {
            int num = queue.poll();
            boolean check = true;
            for(Integer q : queue) {
                if(num < q) {
                    queue.offer(num);
                    if(m == 0) {
                        m = queue.size();
                    }
                    m--;
                    check = false;
                    break;
                }
            }
            if(check == true) {
                answer++;
                if(m == 0) {
                    break;
                }
                m--;
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
