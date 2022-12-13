package section4.sales3;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public int[] solution(int n, int m, int[] arr) {
        int[] answer = new int[n - m + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        int front = 0, index = 0;

        for(int i = 0; i < m - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for(int i = m - 1; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            answer[index] = map.size();
            index++;
            if(map.get(arr[front]) == 1) {
                map.remove(arr[front]);
            }
            else {
                map.put(arr[front], map.get(arr[front]) - 1);
            }
            front++;
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
        for(int x : A.solution(n, m, arr)) {
            System.out.print(x + " ");
        }
    }

}



//import java.util.*;
//class Main {
//    public ArrayList<Integer> solution(int n, int k, int[] arr){
//        ArrayList<Integer> answer = new ArrayList<>();
//        HashMap<Integer, Integer> HM = new HashMap<>();
//        for(int i=0; i<k-1; i++){
//            HM.put(arr[i], HM.getOrDefault(arr[i], 0)+1);
//        }
//        int lt=0;
//        for(int rt=k-1; rt<n; rt++){
//            HM.put(arr[rt], HM.getOrDefault(arr[rt], 0)+1);
//            answer.add(HM.size());
//            HM.put(arr[lt], HM.get(arr[lt])-1);
//            if(HM.get(arr[lt])==0) HM.remove(arr[lt]);
//            lt++;
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
//        for(int x : T.solution(n, k, arr)) System.out.print(x+" ");
//    }
//}