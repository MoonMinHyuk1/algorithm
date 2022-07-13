package section2.bignum1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public ArrayList<Integer> solution(int len, ArrayList<Integer> arr) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        for(int i = 0; i < arr.size(); i++) {
            if(i == 0) {
                answer.add(arr.get(i));
                continue;
            }
            if(arr.get(i - 1) < arr.get(i)) {
                answer.add(arr.get(i));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();

        int len = sc.nextInt();
        for(int i = 0; i < len; i++) {
            int num = sc.nextInt();
            arr.add(num);
        }
        for(int x : A.solution(len, arr)) {
            System.out.print(x + " ");
        }
    }

}



//import java.util.*;
//class Main {
//    public ArrayList<Integer> solution(int n, int[] arr){
//        ArrayList<Integer> answer = new ArrayList<>();
//        answer.add(arr[0]);
//        for(int i=1; i<n; i++){
//            if(arr[i]>arr[i-1]) answer.add(arr[i]);
//        }
//        return answer;
//    }
//
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        int n=kb.nextInt();
//        int[] arr=new int[n];
//        for(int i=0; i<n; i++){
//            arr[i]=kb.nextInt();
//        }
//        for(int x : T.solution(n, arr)){
//            System.out.print(x+" ");
//        }
//    }
//}
