package section3.sequencenum5;

import java.util.Scanner;

public class Main {

    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i < n; i++) {
            int sum = 0;
            for(int j = i; j <= n; j++) {
                sum += j;
                if(sum == n) {
                    answer++;
                    break;
                }
                else if(sum > n) {
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(A.solution(n));
    }

}



//import java.util.*;
//class Main {
//    public int solution(int n){
//        int answer=0, sum=0;
//        int m=n/2+1;
//        int[] arr=new int[m];
//        for(int i=0; i<m; i++) arr[i]=i+1;
//        int lt=0;
//        for(int rt=0; rt<m; rt++){
//            sum+=arr[rt];
//            if(sum==n) answer++;
//            while(sum>=n){
//                sum-=arr[lt++];
//                if(sum==n) answer++;
//            }
//        }
//        return answer;
//    }
//
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        int n=kb.nextInt();
//        System.out.print(T.solution(n));
//    }
//}



//import java.util.*;
//class Main {
//    public int solution(int n){
//        int answer=0, cnt=1;
//        n--;
//        while(n>0){
//            cnt++;
//            n=n-cnt;
//            if(n%cnt==0) answer++;
//        }
//        return answer;
//    }
//
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        int n=kb.nextInt();
//        System.out.print(T.solution(n));
//    }
//}