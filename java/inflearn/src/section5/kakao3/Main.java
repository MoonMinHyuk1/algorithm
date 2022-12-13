package section5.kakao3;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public int solution(int n, int[][] arr, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < m; i++) {
            int index = moves[i] - 1;
            for(int j = 0; j < n; j++) {
                if(arr[j][index] != 0) {
                    if(stack.isEmpty()) {
                        stack.push(arr[j][index]);
                    } else {
                        int num = stack.peek();
                        if(num == arr[j][index]) {
                            answer++;
                            stack.pop();
                        } else {
                            stack.push(arr[j][index]);
                        }
                    }
                    arr[j][index] = 0;
                    break;
                }
            }
        }

        answer *= 2;

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m];
        for(int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }

        System.out.println(A.solution(n, arr, m, moves));
    }
}
