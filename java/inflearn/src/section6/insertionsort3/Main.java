package section6.insertionsort3;

import java.util.Scanner;

public class Main {
    public int[] solution(int n, int[] arr) {
        for(int i = 1; i < n; i++) {
            int target = i;
            for(int j = i - 1; j >=0; j--) {
                if(arr[target] < arr[j]) {
                    int temp = arr[target];
                    arr[target] = arr[j];
                    arr[j] = temp;
                    target--;
                } else {
                    break;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int num : A.solution(n, arr)) {
            System.out.print(num + " ");
        }
    }
}
