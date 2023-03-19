package section1.duplicate6;

import java.util.Scanner;

public class Main {

    public String solution(String str) {
        String answer = "";
        char[] s = str.toCharArray();

        for(int i = 0; i < s.length; i++) {
            boolean check = true;
            for(int j = 0; j < i; j++) {
                if(s[i] == s[j]) {
                    check = false;
                    break;
                }
            }
            if(check == true) {
                answer += s[i];
            }
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
//        String answer="";
//        for(int i=0; i<str.length(); i++){
//            //System.out.println(str.charAt(i)+" "+i+" "+str.indexOf(str.charAt(i)));
//            if(str.indexOf(str.charAt(i))==i) answer+=str.charAt(i);
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