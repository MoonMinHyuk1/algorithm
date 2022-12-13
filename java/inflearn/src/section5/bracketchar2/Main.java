package section5.bracketchar2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for(Character c : str.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else if(c == ')') {
                while(true) {
                    char ch = stack.pop();
                    if(ch == '(') {
                        break;
                    }
                }
            } else {
                stack.push(c);
            }
        }

        while(!stack.isEmpty()) {
            answer += stack.pop();
        }
        StringBuffer sb = new StringBuffer(answer);
        answer = sb.reverse().toString();

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(A.solution(str));
    }
}
