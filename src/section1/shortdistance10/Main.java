package section1.shortdistance10;

import java.util.Scanner;

public class Main {

    public int[] solution(String s, String t) {
        int[] answer = new int[s.length()];
        int min;

        for(int i = 0; i < answer.length; i++) {
            min = answer.length;
            for(int j = 0; j < answer.length; j++) {
                if(s.charAt(j) == t.charAt(0)) {
                    int len = i - j;
                    if(len < 0) {
                        len = len * (-1);
                    }
                    if(len < min) {
                        min = len;
                    }
                }
            }
            answer[i] = min;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();
        int[] answer = A.solution(s, t);
        for(int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

}



//import java.util.*;
//class Main {
//    public int[] solution(String s, char t){
//        int[] answer=new int[s.length()];
//        int p=1000;
//        for(int i=0; i<s.length(); i++){
//            if(s.charAt(i)==t){
//                p=0;
//                answer[i]=p;
//            }
//            else{
//                p++;
//                answer[i]=p;
//            }
//        }
//        p=1000;
//        for(int i=s.length()-1; i>=0; i--){
//            if(s.charAt(i)==t) p=0;
//            else{
//                p++;
//                answer[i]=Math.min(answer[i], p);
//            }
//        }
//        return answer;
//    }
//
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        String str=kb.next();
//        char c=kb.next().charAt(0);
//        for(int x : T.solution(str, c)){
//            System.out.print(x+" ");
//        }
//    }
//}