package section3.maxlengthpart6;

import java.util.Scanner;

public class Main {

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int k = m, count = 0, front = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                if(k != 0) {
                    k--;
                    count++;
                    if(count > answer) {
                        answer = count;
                    }
                }
                else {
                    if(count > answer) {
                        answer = count;
                    }
                    if(arr[front] == 0) {
                        front++;
                    }
                    else if(arr[front] == 1) {
                        while(arr[front] == 1) {
                            count--;
                            front++;
                        }
                        front++;
                    }
                }
            }
            else if(arr[i] == 1) {
                count++;
                if(count > answer) {
                    answer = count;
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
//        int answer=0, cnt=0, lt=0;
//        for(int rt=0; rt<n; rt++){
//            if(arr[rt]==0) cnt++;
//            while(cnt>k){
//                if(arr[lt]==0) cnt--;
//                lt++;
//            }
//            answer=Math.max(answer, rt-lt+1);
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