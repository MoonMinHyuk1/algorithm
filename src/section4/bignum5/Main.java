package section4.bignum5;

import java.util.*;

public class Main {
    public int solution(int n, int k, int[] arr) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> maxArr = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int l = j + 1; l < n; l++) {
                    int sum = arr[i] + arr[j] + arr[l];
                    maxArr.add(sum);
                }
            }
        }
        Collections.sort(maxArr);
        for(int i = maxArr.size() - 1; i >= 0; i--) {
            map.put(maxArr.get(i), map.getOrDefault(maxArr.get(i), 0) + 1);
            if(map.size() == k) {
                answer = maxArr.get(i);
                return answer;
            }
        }
        answer = -1;

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(A.solution(n, k, arr));
    }

}



//import java.util.*;
//class Main {
//    public int solution(int[] arr, int n, int k){
//        int answer=-1;
//        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
//        for(int i=0; i<n; i++){
//            for(int j=i+1; j<n; j++){
//                for(int l=j+1; l<n; l++){
//                    Tset.add(arr[i]+arr[j]+arr[l]);
//                }
//            }
//        }
//        int cnt=0;
//        //Tset.remove(143);
//        //System.out.println(Tset.size());
//        //System.out.println("first : "+ Tset.first());
//        //System.out.println("last : "+ Tset.last());
//
//        for(int x : Tset){
//            //System.out.println(x);
//            cnt++;
//            if(cnt==k) return x;
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
//        System.out.println(T.solution(arr, n, k));
//    }
//}