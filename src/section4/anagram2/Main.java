package section4.anagram2;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public String solution(char[] arr1, char[] arr2) {
        String answer = "";
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i < arr1.length; i++) {
            map1.put(arr1[i], map1.getOrDefault(arr1[i], 0) + 1);
        }
        for(int i = 0; i < arr2.length; i++) {
            map2.put(arr2[i], map2.getOrDefault(arr2[i], 0) + 1);
        }
        for(char key : map1.keySet()) {
            if(map1.get(key) != map2.get(key)) {
                answer = "NO";
                return answer;
            }
        }
        answer = "YES";

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        String arr1 = sc.nextLine();
        String arr2 = sc.nextLine();
        System.out.println(A.solution(arr1.toCharArray(), arr2.toCharArray()));
    }

}



//import java.util.*;
//class Main {
//    public String solution(String s1, String s2){
//        String answer="YES";
//        HashMap<Character, Integer> map=new HashMap<>();
//        for(char x : s1.toCharArray()){
//            map.put(x, map.getOrDefault(x, 0)+1);
//        }
//        for(char x : s2.toCharArray()){
//            if(!map.containsKey(x) || map.get(x)==0) return "NO";
//            map.put(x, map.get(x)-1);
//        }
//        return answer;
//    }
//
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        String a=kb.next();
//        String b=kb.next();
//        System.out.print(T.solution(a, b));
//    }
//}