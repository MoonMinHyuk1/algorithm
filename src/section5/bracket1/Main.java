package section5.bracket1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public String solution(String str) {
        String answer = "NO";
        Queue queue = new LinkedList();

        for(char c : str.toCharArray()) {
            if(c == '(') {
                queue.offer(c);
            } else if(c == ')') {
                if(queue.isEmpty()) {
                    return answer;
                } else {
                    queue.poll();
                }
            }
        }

        if(queue.isEmpty()) {
            return "YES";
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
