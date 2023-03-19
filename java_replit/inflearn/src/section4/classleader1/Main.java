package section4.classleader1;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public char solution(int n, char[] arr) {
        char answer = '0';
        HashMap<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            if(map.get(arr[i]) == null) {
                map.put(arr[i], 1);
            }
            else {
                int cnt = map.get(arr[i]);
                map.put(arr[i], cnt + 1);
            }
        }
        for(Character c : map.keySet()) {
            if(map.get(c) > max) {
                max = map.get(c);
                answer = c;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[] arr = new char[n];
        String str = sc.next();
        arr = str.toCharArray();
        System.out.println(A.solution(n, arr));
    }

}



//import java.util.*;
//class Main {
//    public char solution(int n, String s){
//        char answer=' ';
//        HashMap<Character, Integer> map=new HashMap<>();
//        for(char x : s.toCharArray()){
//            map.put(x, map.getOrDefault(x, 0)+1);
//        }
//        //System.out.println(map.containsKey('F'));
//        //System.out.println(map.size());
//        //System.out.println(map.remove('C'));
//
//        int max=Integer.MIN_VALUE;
//        for(char key : map.keySet()){
//            //System.out.println(key+" "+map.get(key));
//            if(map.get(key)>max){
//                max=map.get(key);
//                answer=key;
//            }
//        }
//        return answer;
//    }
//
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        int n=kb.nextInt();
//        String str=kb.next();
//        System.out.println(T.solution(n, str));
//    }
//}