package section1.findstring1;

import java.util.Scanner;

public class Main {

    public int solution(String str, String c) {
        int answer = 0;

        str = str.toUpperCase();
        c = c.toUpperCase();

//        for(int i = 0; i < str.length(); i++) {
//            if(str.charAt(i) == c.charAt(0)) {
//                answer++;
//            }
//        }

        for (char x : str.toCharArray()) {
            if(x == c.charAt(0)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String c = sc.nextLine();

        System.out.println(A.solution(str, c));
    }

}
