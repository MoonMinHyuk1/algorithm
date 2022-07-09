package section1.instring3;

import java.util.Scanner;

public class Main {

    public String solution(String str) {
        String answer = "";
        String[] spl = str.split(" ");
        int max = 0, index = 0;

//        for(int i = 0; i < spl.length; i++) {
//            if(spl[i].length() > max) {
//                max = spl[i].length();
//                index = i;
//            }
//        }
//        answer = spl[index];

        int pos;
        while((pos = str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len > max) {
                max = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }
        if(str.length() > max) {
            answer = str;
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
