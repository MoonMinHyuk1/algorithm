package section1.translate2;

import java.util.Scanner;

public class Main {

    public String solution(String str) {
        String answer = "";

//        for(int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//
//            if(c >= 'a' && c <= 'z') {
//                c = Character.toUpperCase(c);
//            }
//            else if(c >= 'A' && c <= 'Z') {
//                c = Character.toLowerCase(c);
//            }
//
//            answer += c;
//        }

        for(char x : str.toCharArray()) {
            if(Character.isLowerCase(x)) {
                x = Character.toUpperCase(x);
            }
            else if(Character.isUpperCase(x)) {
                x = Character.toLowerCase(x);
            }
            answer += x;
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
