package section1.specialwordchange5;

import java.util.Scanner;

public class Main {

    public char[] solution(String str) {
        char[] answer = str.toCharArray();
        int lt = 0, rt = answer.length - 1;

        while(lt < rt) {
            boolean lt_check = false;
            boolean rt_check = false;
            if((answer[lt] >= 'a' && answer[lt] <= 'z') || (answer[lt] >= 'A' && answer[lt] <= 'Z')) {
                lt_check = true;
            }
            if((answer[rt] >= 'a' && answer[rt] <= 'z') || (answer[rt] >= 'A' && answer[rt] <= 'Z')) {
                rt_check = true;
            }
            if(lt_check == true && rt_check == true) {
                char temp = answer[lt];
                answer[lt] = answer[rt];
                answer[rt] = temp;
                lt++;
                rt--;
            }
            if(lt_check == false) {
                lt++;
            }
            if(rt_check == false) {
                rt--;
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
//        String answer;
//        char[] s=str.toCharArray();
//        int lt=0, rt=str.length()-1;
//        while(lt<rt){
//            if(!Character.isAlphabetic(s[lt])) lt++;
//            else if(!Character.isAlphabetic(s[rt])) rt--;
//            else{
//                char tmp=s[lt];
//                s[lt]=s[rt];
//                s[rt]=tmp;
//                lt++;
//                rt--;
//            }
//        }
//        answer=String.valueOf(s);
//        return answer;
//    }
//
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        String str=kb.next();
//        System.out.println(T.solution(str));
//    }
//}