package section1.changenumber9;

import java.util.Scanner;

public class Main {

    public int solution(String str) {
        int answer = 0;
        String temp = str.replaceAll("[^0-9]", "");

        answer = Integer.parseInt(temp);

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
//    public int solution(String s){
//        //int answer=0;
//        String answer="";
//        for(char x : s.toCharArray()){
//            //if(x>=48 && x<=57) answer=answer*10+(x-48);
//			/*if(Character.isDigit(x)){
//				answer=answer*10+ Character.getNumericValue(x);
//			}*/
//            if(Character.isDigit(x)) answer+=x;
//        }
//        return Integer.parseInt(answer);
//    }
//
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        String str=kb.next();
//        System.out.print(T.solution(str));
//    }
//}