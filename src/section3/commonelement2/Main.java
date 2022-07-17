package section3.commonelement2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public ArrayList<Integer> arrayListSort(ArrayList<Integer> arr) {

        for(int i = 0; i < arr.size() - 1; i++) {
            int num = arr.get(i);
            int index = i;
            for(int j = i + 1; j < arr.size(); j++) {
                if(num > arr.get(j)) {
                    num = arr.get(j);
                    index = j;
                }
            }
            if(index != i) {
                arr.set(index, arr.get(i));
                arr.set(i, num);
            }
        }

        return arr;
    }

    public ArrayList<Integer> solution(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int arr1_index = 0, arr2_index = 0;

        arr1 = arrayListSort(arr1);
        arr2 = arrayListSort(arr2);
        while(arr1_index < n && arr2_index < m) {
            if(arr1.get(arr1_index) == arr2.get(arr2_index)) {
                answer.add(arr1.get(arr1_index));
                arr1_index++;
                arr2_index++;
                continue;
            }
            if(arr1.get(arr1_index) > arr2.get(arr2_index)) {
                arr2_index++;
                continue;
            }
            if(arr1.get(arr1_index) < arr2.get(arr2_index)) {
                arr1_index++;
                continue;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> arr1 = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            arr1.add(sc.nextInt());
        }
        int m = sc.nextInt();
        ArrayList<Integer> arr2 = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            arr2.add(sc.nextInt());
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
//        Arrays.sort(a);
//        Arrays.sort(b);
//        int p1=0, p2=0;
//        while(p1<n && p2<m){
//            if(a[p1]==b[p2]){
//                answer.add(a[p1++]);
//                p2++;
//            }
//            else if(a[p1]<b[p2]) p1++;
//            else p2++;
//        }
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