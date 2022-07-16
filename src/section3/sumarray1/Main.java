package section3.sumarray1;

import java.util.Scanner;

public class Main {

    public int[] solution(int n, int m, int[] arr1, int[] arr2) {
        int[] answer = new int[n + m];
        int arr1_index = 0, arr2_index = 0;

        for(int i = 0; i < answer.length; i++) {
            if(arr1_index == arr1.length) {
                answer[i] = arr2[arr2_index];
                arr2_index++;
                continue;
            }
            if(arr2_index == arr2.length) {
                answer[i] = arr1[arr1_index];
                arr1_index++;
                continue;
            }
            if(arr1[arr1_index] < arr2[arr2_index]) {
                answer[i] = arr1[arr1_index];
                arr1_index++;
            }
            else {
                answer[i] = arr2[arr2_index];
                arr2_index++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        for(int x : A.solution(n, m, arr1, arr2)) {
            System.out.print(x + " ");
        }
    }

}



//import java.util.*;
//class Main {
//    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
//        ArrayList<Integer> answer = new ArrayList<>();
//        int p1=0, p2=0;
//        while(p1<n && p2<m){
//            if(a[p1]<b[p2]) answer.add(a[p1++]);
//            else answer.add(b[p2++]);
//        }
//        while(p1<n) answer.add(a[p1++]);
//        while(p2<m) answer.add(b[p2++]);
//        return answer;
//    }
//
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        int n=kb.nextInt();
//        int[] a=new int[n];
//        for(int i=0; i<n; i++){
//            a[i]=kb.nextInt();
//        }
//        int m=kb.nextInt();
//        int[] b=new int[m];
//        for(int i=0; i<m; i++){
//            b[i]=kb.nextInt();
//        }
//        for(int x : T.solution(n, m, a, b)) System.out.print(x+" ");
//    }
//}