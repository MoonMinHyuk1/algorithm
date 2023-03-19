package section2.student2;

import java.util.Scanner;

public class Main {

    public int solution(int[] arr) {
        int answer = 1;

        for(int i = 1; i < arr.length; i++) {
            boolean check = true;
            for(int j = 0; j < i; j++) {
                if(arr[j] >= arr[i]) {
                    check = false;
                    break;
                }
            }
            if(check == true) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(A.solution(arr));
    }

}



//import java.util.*;
//class Main {
//    public int solution(int n, int[] arr){
//        int answer=1, max=arr[0];
//        for(int i=1; i<n; i++){
//            if(arr[i]>max){
//                max=arr[i];
//                answer++;
//            }
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