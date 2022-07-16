package section2.mentoring12;

import java.util.Scanner;

public class Main {

    public int solution(int n, int m, int[][] arr) {
        int answer = 0;

//        for(int i = 0; i < n - 1; i++) {
//            for(int j = i + 1; j < n; j++) {
//                int cnt = 0;
//                for(int k = 0; k < m; k++) {
//                    if(arr[k][i] > arr[k][j]) {
//                        cnt++;
//                    }
//                }
//                if(cnt == 0 || cnt == m) {
//                    answer++;
//                }
//            }
//        }
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                int mentor = arr[0][i];
                int mentee = arr[0][j];
                boolean check = true;
                for(int k = 1; k < m; k++) {
                    int mentor_index = -1, mentee_index = -1;
                    for(int l = 0; l < n; l++) {
                        if(arr[k][l] == mentor) {
                            mentor_index = l;
                        }
                        if(arr[k][l] == mentee) {
                            mentee_index = l;
                        }
                    }
                    if(mentor_index > mentee_index) {
                        check = false;
                        break;
                    }
                }
                if(check == true) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(A.solution(n, m, arr));
    }

}



//import java.util.*;
//class Main {
//    public int solution(int n, int m, int[][] arr){
//        int answer=0;
//        for(int i=1; i<=n; i++){
//            for(int j=1; j<=n; j++){
//                int cnt=0;
//                for(int k=0; k<m; k++){
//                    int pi=0, pj=0;
//                    for(int s=0; s<n; s++){
//                        if(arr[k][s]==i) pi=s;
//                        if(arr[k][s]==j) pj=s;
//                    }
//                    if(pi<pj) cnt++;
//                }
//                if(cnt==m){
//                    answer++;
//                    //System.out.println(i+" "+j);
//                }
//            }
//        }
//        return answer;
//    }
//
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        int n=kb.nextInt();
//        int m=kb.nextInt();
//        int[][] arr=new int[m][n];
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                arr[i][j]=kb.nextInt();
//            }
//        }
//        System.out.print(T.solution(n, m, arr));
//    }
//}