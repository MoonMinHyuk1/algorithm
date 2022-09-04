package section5.curriculum7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public String solution(String str1, String str2) {
        String answer = "NO";
        Queue<Character> queue = new LinkedList<>();

        for(Character c : str1.toCharArray()) {
            queue.offer(c);
        }
        for(Character c : str2.toCharArray()) {
            if(c == queue.peek()) {
                queue.poll();
            }
        }
        if(queue.isEmpty()) {
            answer = "YES";
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(A.solution(str1, str2));
    }
}
