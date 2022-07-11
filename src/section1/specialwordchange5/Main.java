package section1.specialwordchange5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public char[] solution(String str) {
        char[] answer = str.toCharArray();
        int lt = 0, rt = answer.length - 1;

        while(lt < rt) {
            char temp = answer[lt];
            answer[lt] = answer[rt];
            answer[rt] = temp;
            lt++;
            rt--;
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
