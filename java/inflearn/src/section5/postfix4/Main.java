package section5.postfix4;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(Character c : str.toCharArray()) {
            if(c == '+' || c == '-' || c == '*' || c == '/') {
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;
                switch(c) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        result = a / b;
                        break;
                }
                stack.push(result);
            } else {
                stack.push(c - '0');
            }
        }

        answer = stack.pop();

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(A.solution(str));
    }
}
