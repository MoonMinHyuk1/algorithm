package section6.jokeman6;

import java.util.Scanner;

public class Main {
    public int[] solution(int n, int[] arr) {
        int[] answer = new int[2];
        int[] sortArr = new int[n];
        int index = 0;

        for(int i = 0; i < n; i++) {
            sortArr[i] = arr[i];
        }
        for(int i = 1; i < n; i++) {
            int target = i;
            for(int j = i - 1; j >=0; j--) {
                if(sortArr[target] < sortArr[j]) {
                    int temp = sortArr[target];
                    sortArr[target] = sortArr[j];
                    sortArr[j] = temp;
                    target--;
                } else {
                    break;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            if(sortArr[i] != arr[i]) {
                answer[index++] = i + 1;
            }
        }

        return answer;
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
