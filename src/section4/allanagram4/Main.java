package section4.allanagram4;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public int solution(char[] S, char[] T) {
        int answer = 0;
        int lt = 0;
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        for(int i = 0; i < T.length; i++) {
            mapT.put(T[i], mapT.getOrDefault(T[i], 0) + 1);
        }
        for(int i = 0; i < T.length - 1; i++) {
            mapS.put(S[i], mapS.getOrDefault(S[i], 0) + 1);
        }
        for(int i = T.length - 1; i < S.length; i++) {
            mapS.put(S[i], mapS.getOrDefault(S[i], 0) + 1);
            boolean check = true;
            for(Character c : mapS.keySet()) {
                if(mapS.get(c) != mapT.get(c)) {
                    check = false;
                    break;
                }
            }
            if(check == true) {
                answer++;
            }
            if(mapS.get(S[lt]) == 1) {
                mapS.remove(S[lt]);
            }
            else if(mapS.get(S[lt]) > 1) {
                mapS.put(S[lt], mapS.get(S[lt]) - 1);
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        String T = sc.nextLine();
        System.out.println(A.solution(S.toCharArray(), T.toCharArray()));
    }

}



//import java.util.*;
//class Main {
//    public int solution(String a, String b){
//        int answer=0;
//        HashMap<Character, Integer> am=new HashMap<>();
//        HashMap<Character, Integer> bm=new HashMap<>();
//        for(char x : b.toCharArray()) bm.put(x, bm.getOrDefault(x, 0)+1);
//        int L=b.length()-1;
//        for(int i=0; i<L; i++) am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0)+1);
//        int lt=0;
//        for(int rt=L; rt<a.length(); rt++){
//            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0)+1);
//            if(am.equals(bm)) answer++;
//            am.put(a.charAt(lt), am.get(a.charAt(lt))-1);
//            if(am.get(a.charAt(lt))==0) am.remove(a.charAt(lt));
//            lt++;
//        }
//        return answer;
//    }
//
//
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        String a=kb.next();
//        String b=kb.next();
//        System.out.print(T.solution(a, b));
//    }
//}