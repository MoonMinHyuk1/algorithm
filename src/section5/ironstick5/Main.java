package section5.ironstick5;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public int solution(String str) {
        int answer = 0, cnt = 0;
        Stack<Character> stack = new Stack<>();

        for(Character c : str.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else if(c == ')') {
                if(stack.peek() == '(') {
                    stack.push(c);
                    cnt++;
                    answer += stack.size() - (2 * cnt);
                } else if(stack.peek() == ')') {
                    stack.push(c);
                    cnt++;
                    answer += 1;
                }
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
