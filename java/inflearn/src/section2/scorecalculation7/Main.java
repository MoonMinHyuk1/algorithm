package section2.scorecalculation7;

import java.util.Scanner;

public class Main {

    public int solution(int[] arr) {
        int answer = 0;
        int score = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                score++;
                answer += score;
            }
            else {
                score = 0;
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
        System.out.println(A.solution(arr));
    }

}



//import java.util.*;
//class Main {
//    public int solution(int n, int[] arr){
//        int answer=0, cnt=0;
//        for(int i=0; i<n; i++){
//            if(arr[i]==1){
//                cnt++;
//                answer+=cnt;
//            }
//            else cnt=0;
//        }
//        return answer;
//    }
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        int n=kb.nextInt();
//        int[] arr=new int[n];
//        for(int i=0; i<n; i++){
//            arr[i]=kb.nextInt();
//        }
//        System.out.print(T.solution(n, arr));
//    }
//}