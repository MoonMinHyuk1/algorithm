package section3.maxsales3;

import java.util.Scanner;

public class Main {

    public int solution(int n, int m, int[] arr) {
        int answer = 0;

//        for(int i = m - 1; i < n; i++) {
//            int sum = 0;
//            for(int j = i; j > i - m; j--) {
//                sum += arr[j];
//            }
//            if(answer < sum) {
//                answer = sum;
//            }
//        }
        int sum = 0, front = 0;
        for(int i = 0; i < n; i++) {
            if(i <= m - 1) {
                sum += arr[i];
                if(i == m - 1) {
                    answer = sum;
                }
                continue;
            }
            sum = sum - arr[front];
            sum = sum + arr[i];
            front++;
            if(answer < sum) {
                answer = sum;
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
//    public int solution(int n, int k, int[] arr){
//        int answer, sum=0;
//        for(int i=0; i<k; i++) sum+=arr[i];
//        answer=sum;
//        for(int i=k; i<n; i++){
//            sum+=(arr[i]-arr[i-k]);
//            answer=Math.max(answer, sum);
//        }
//        return answer;
//    }
//
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        int n=kb.nextInt();
//        int k=kb.nextInt();
//        int[] arr=new int[n];
//        for(int i=0; i<n; i++){
//            arr[i]=kb.nextInt();
//        }
//        System.out.print(T.solution(n, k, arr));
//    }
//}