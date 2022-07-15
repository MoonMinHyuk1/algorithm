package section2.rank8;

import java.util.Scanner;

public class Main {

    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            int rank = 1;
            for(int j = 0; j < arr.length; j++) {
                if(i == j) {
                    continue;
                }
                if(arr[i] < arr[j]) {
                    rank++;
                }
            }
            answer[i] = rank;
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
        for(int x : A.solution(arr)) {
            System.out.print(x + " ");
        }
    }

}



//import java.util.*;
//class Main {
//    public int[] solution(int n, int[] arr){
//        int[] answer = new int[n];
//        for(int i=0; i<n; i++){
//            int cnt=1;
//            for(int j=0; j<arr.length; j++){
//                if(arr[j]>arr[i]) cnt++;
//            }
//            answer[i]=cnt;
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
//        for(int x :T.solution(n, arr)) System.out.print(x+" ");
//    }
//}