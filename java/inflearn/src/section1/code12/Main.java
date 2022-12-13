package section1.code12;

import java.util.Scanner;

public class Main {

    public String solution(int cnt, String str) {
        String answer = "";

        str = str.replace('#', '1');
        str = str.replace('*', '0');
        for(int i = 0; i < cnt; i++) {
            int index = i * 7;
            int num = 0, binary = 1;
            for(int j = index + 6; j >= index; j--) {
                if(str.charAt(j) == '1') {
                    num += binary;
                }
                binary *= 2;
            }
            char c = (char)num;
            answer += c;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        System.out.println(A.solution(cnt, str));
    }

}



//import java.util.*;
//class Main {
//    public String solution(int n, String s){
//        String answer="";
//        for(int i=0; i<n; i++){
//            String tmp=s.substring(0, 7).replace('#', '1').replace('*', '0');
//            int num=Integer.parseInt(tmp, 2);
//            answer+=(char)num;
//            s=s.substring(7);
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