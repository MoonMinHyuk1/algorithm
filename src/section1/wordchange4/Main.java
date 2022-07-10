package section1.wordchange4;

import java.util.Scanner;

public class Main {

    public String[] solution(int n, String[] str) {
        String[] answer = new String[n];

        for(int i = 0; i < str.length; i++) {
            answer[i] = "";
            for(int j = str[i].length() - 1; j >= 0; j--) {
                answer[i] += str[i].charAt(j);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] str = new String[n];
        sc.nextLine();
        for(int i = 0; i < n; i++) {
            str[i] = sc.nextLine();
        }

        String[] answer = A.solution(str.length, str);
        for(int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

}



//answer
//import java.util.*;
//class Main {
//    public ArrayList<String> solution(int n, String[] str){
//        ArrayList<String> answer=new ArrayList<>();
//        for(String x : str){
//            String tmp=new StringBuilder(x).reverse().toString();
//            answer.add(tmp);
//        }
//        return answer;
//    }
//
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        int n=kb.nextInt();
//        String[] str=new String[n];
//        for(int i=0; i<n; i++){
//            str[i]=kb.next();
//        }
//        for(String x : T.solution(n, str)){
//            System.out.println(x);
//        }
//    }
//}
//
//
//
//import java.util.*;
//class Main {
//    public ArrayList<String> solution(int n, String[] str){
//        ArrayList<String> answer=new ArrayList<>();
//        for(String x : str){
//            char[] s=x.toCharArray();
//            int lt=0, rt=x.length()-1;
//            while(lt<rt){
//                char tmp=s[lt];
//                s[lt]=s[rt];
//                s[rt]=tmp;
//                lt++;
//                rt--;
//            }
//            String tmp=String.valueOf(s);
//            answer.add(tmp);
//        }
//        return answer;
//    }
//
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        int n=kb.nextInt();
//        String[] str=new String[n];
//        for(int i=0; i<n; i++){
//            str[i]=kb.next();
//        }
//        for(String x : T.solution(n, str)){
//            System.out.println(x);
//        }
//    }
//}
//
//
