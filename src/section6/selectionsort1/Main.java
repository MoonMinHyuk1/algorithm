package section6.selectionsort1;

import java.util.Scanner;

public class Main {
    public int[] solution(int n, int[] arr) {
        for(int i = 0; i < n - 1; i++) {
            int index = i;
            for(int j = i + 1; j < n; j++) {
                if(arr[index] > arr[j]) {
                    index = j;
                }
            }
            if(index != i) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
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
