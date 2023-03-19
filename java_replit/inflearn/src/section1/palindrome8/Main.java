package section1.palindrome8;

import java.util.Scanner;

public class Main {

    public String solution(String str) {
        String answer = "YES";
        String temp = str.replaceAll("[^a-zA-Z]", "");

        temp = temp.toUpperCase();
        for(int i = 0; i < temp.length() / 2; i++) {
            if(temp.charAt(i) != temp.charAt(temp.length() - i - 1)) {
                answer = "NO";
                break;
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
//    public String solution(String s){
//        String answer="NO";
//        s=s.toUpperCase().replaceAll("[^A-Z]", "");
//        String tmp=new StringBuilder(s).reverse().toString();
//        if(s.equals(tmp)) answer="YES";
//        return answer;
//    }
//
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        String str=kb.nextLine();
//        System.out.print(T.solution(str));
//    }
//}