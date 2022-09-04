package section5.princess6;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public int solution(int n, int k) {
        int answer = 0, index = k - 1;
        Stack<Integer> stack = new Stack<>();

        for(int i = 1; i <= n; i++) {
            stack.push(i);
        }
        while(stack.size() > 1) {
            while(index >= stack.size()) {
                index = index - stack.size();
            }
            int num = stack.remove(index);
            index = index + k - 1;
        }

        answer = stack.pop();

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(A.solution(n, k));
    }
}
