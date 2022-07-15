package section2.maxsum9;

import java.util.Scanner;

public class Main {

    public int solution(int n, int[][] arr) {
        int answer = 0;
        int max = 0, maxR = 0, maxC = 0, maxD = 0, diagonal1 = 0, diagonal2 = 0;

        for(int i = 0; i < n; i++) {
            int row = 0, column = 0;
            for(int j = 0; j < n; j++) {
                row += arr[i][j];
                column += arr[j][i];
                if(i == j) {
                    diagonal1 += arr[i][j];
                }
                if(i != j && i + j == n - 1) {
                    diagonal2 += arr[i][j];
                }
            }
            if(maxR < row) {
                maxR = row;
            }
            if(maxC < column) {
                maxC = column;
            }
        }
        maxD = Integer.max(diagonal1, diagonal2);
        max = Integer.max(maxR, maxC);
        answer = Integer.max(maxD, max);

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
        System.out.println(A.solution(n, arr));
    }

}



//import java.util.*;
//class Main {
//    public int solution(int n, int[][] arr){
//        int answer=-2147000000;
//        int sum1=0, sum2=0;
//        for(int i=0; i<n; i++){
//            sum1=sum2=0;
//            for(int j=0; j<n; j++){
//                sum1+=arr[i][j];
//                sum2+=arr[j][i];
//            }
//            answer=Math.max(answer, sum1);
//            answer=Math.max(answer, sum2);
//        }
//        sum1=sum2=0;
//        for(int i=0; i<n; i++){
//            sum1+=arr[i][i];
//            sum2+=arr[i][n-i-1];
//        }
//        answer=Math.max(answer, sum1);
//        answer=Math.max(answer, sum2);
//        return answer;
//    }
//
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        int n=kb.nextInt();
//        int[][] arr=new int[n][n];
//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++){
//                arr[i][j]=kb.nextInt();
//            }
//        }
//        System.out.print(T.solution(n, arr));
//    }
//}