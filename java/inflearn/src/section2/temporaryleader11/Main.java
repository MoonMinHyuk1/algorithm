package section2.temporaryleader11;

import java.util.Scanner;

public class Main {

    public int solution(int n, int[][] arr) {
        int answer = 0;
        boolean[][] check = new boolean[n][n];
        int max = 0, index = 0;

        for(int i = 0; i < 5; i++) {
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(j == k) {
                        continue;
                    }
                    if(arr[j][i] == arr[k][i]) {
                        check[j][k] = true;
                        check[k][j] = true;
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(check[i][j] == true) {
                    cnt++;
                }
            }
            if(cnt > max) {
                max = cnt;
                index = i;
            }
        }
        answer = index + 1;

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][5];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(A.solution(n, arr));
    }

}



//import java.util.*;
//class Main {
//    public int solution(int n, int[][] arr){
//        int answer=0, max=0;
//        for(int i=1; i<=n; i++){
//            int cnt=0;
//            for(int j=1; j<=n; j++){
//                for(int k=1; k<=5; k++){
//                    if(arr[i][k]==arr[j][k]){
//                        cnt++;
//                        break;
//                    }
//                }
//            }
//            if(cnt>max){
//                max=cnt;
//                answer=i;
//            }
//        }
//        return answer;
//    }
//
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        int n=kb.nextInt();
//        int[][] arr=new int[n+1][6];
//        for(int i=1; i<=n; i++){
//            for(int j=1; j<=5; j++){
//                arr[i][j]=kb.nextInt();
//            }
//        }
//        System.out.print(T.solution(n, arr));
//    }
//}