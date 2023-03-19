package section6.coordinate7;

import java.util.Scanner;

public class Main {
    public int[][] solution(int n, int[][] arr) {
        for(int i = 1; i < n; i++) {
            int targetX = arr[i][0];
            int targetY = arr[i][1];
            int j ;
            for(j = i - 1; j >= 0; j--) {
                if(arr[j][0] > targetX) {
                    arr[j + 1][0] = arr[j][0];
                    arr[j + 1][1] = arr[j][1];
                } else {
                    break;
                }
            }
            arr[j + 1][0] = targetX;
            arr[j + 1][1] = targetY;
        }
        for(int i = 1; i < n; i++) {
            int targetX = arr[i][0];
            int targetY = arr[i][1];
            int j;
            for(j = i - 1; j >= 0; j--) {
                if(arr[j][1] > targetY && arr[j][0] == arr[i][0]) {
                    arr[j + 1][0] = arr[j][0];
                    arr[j + 1][1] = arr[j][1];
                } else {
                    break;
                }
            }
            arr[j + 1][0] = targetX;
            arr[j + 1][1] = targetY;
        }

        return arr;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] answer = A.solution(n, arr);
        for(int i = 0; i < n; i++) {
            System.out.println(answer[i][0] + " " + answer[i][1]);
        }
    }
}
