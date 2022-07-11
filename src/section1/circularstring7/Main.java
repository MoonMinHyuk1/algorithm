package section1.circularstring7;

import java.util.Scanner;

public class Main {

    public String solution(String str) {
        String answer = "YES";
        char[] s = str.toUpperCase().toCharArray();
        int lt = 0, rt = s.length - 1;

        while(lt < rt) {
            if(s[lt] != s[rt]) {
                answer = "NO";
                return answer;
            }
            lt++;
            rt--;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(A.solution(str));
    }

}



//import java.util.*;
//class Main {
//    public String solution(String str){
//        String answer="YES";
//        str=str.toUpperCase();
//        int len=str.length();
//        for(int i=0; i<len/2; i++){
//            if(str.charAt(i)!=str.charAt(len-i-1)) answer="NO";
//        }
//        return answer;
//    }
//
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        String str=kb.next();
//        System.out.print(T.solution(str));
//    }
//}
//
//
//
//import java.util.*;
//class Main {
//    public String solution(String str){
//        String answer="NO";
//        String tmp=new StringBuilder(str).reverse().toString();
//        if(str.equalsIgnoreCase(tmp)) answer="YES";
//        return answer;
//    }
//
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        String str=kb.next();
//        System.out.print(T.solution(str));
//    }
//}
