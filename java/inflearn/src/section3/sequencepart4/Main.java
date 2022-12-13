package section3.sequencepart4;

import java.util.Scanner;

public class Main {

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0, front = 0;

        for(int i = 0; i < n; i++) {
            sum += arr[i];
            if(sum == m) {
                answer++;
            }
            while(sum > m) {
                sum = sum - arr[front];
                if(sum == m) {
                    answer++;
                }
                front++;
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



//import java.util.*;
//class Main {
//    public int solution(int n, int m, int[] arr){
//        int answer=0, sum=0, lt=0;
//        for(int rt=0; rt<n; rt++){
//            sum+=arr[rt];
//            if(sum==m) answer++;
//            while(sum>=m){
//                sum-=arr[lt++];
//                if(sum==m) answer++;
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
//        int[] arr=new int[n];
//        for(int i=0; i<n; i++){
//            arr[i]=kb.nextInt();
//        }
//        System.out.print(T.solution(n, m, arr));
//    }
//}