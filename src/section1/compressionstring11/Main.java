package section1.compressionstring11;

import java.util.Scanner;

public class Main {

    public String solution(String str) {
        String answer = "";

        for(int i = 0; i < str.length(); i++) {
            int cnt = 0;
            for(int j = i; j < str.length(); j++) {
                if(str.charAt(i) == str.charAt(j)) {
                    cnt++;
                }
                else {
                    break;
                }
            }
            if(cnt == 1) {
                answer += str.charAt(i);
            }
            else {
                answer += str.charAt(i);
                answer += cnt;
            }
            i = i + cnt - 1;
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
//        String answer="";
//        s=s+" ";
//        int cnt=1;
//        for(int i=0; i<s.length()-1; i++){
//            if(s.charAt(i)==s.charAt(i+1)) cnt++;
//            else{
//                answer+=s.charAt(i);
//                if(cnt>1) answer+=String.valueOf(cnt);
//                cnt=1;
//            }
//        }
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