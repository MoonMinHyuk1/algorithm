import java.util.*;

class Solution {
    
    public long calculate(long n1, String symbol, long n2) {
        if(symbol.equals("+")) return n1 + n2;
        else if(symbol.equals("-")) return n1 - n2;
        else return n1 * n2;
    }
    
    public long express(Queue<String> queue, String[] symbols) {
        Queue<String> q1 = new LinkedList<>();
        
        for(String str: queue) q1.offer(str);
        for(int i = 0; i < symbols.length; i++) {
            Deque<String> q2 = new ArrayDeque<>();
            while(!q1.isEmpty()) {
                String s = q1.poll();
                if(s.equals(symbols[i])) {
                    long n1 = Long.parseLong(q2.pollLast());
                    long n2 = Long.parseLong(q1.poll());
                    q2.offer(String.valueOf(calculate(n1, s, n2)));
                } else {
                    q2.offer(s);
                }
            }
            while(!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
        }
        
        return Math.abs(Long.parseLong(q1.poll()));
    }
    
    public long solution(String expression) {
        long answer = 0;
        Queue<String> queue = new LinkedList<>();
        String[][] symbols = {{"+", "-", "*"}, {"+", "*", "-"}, {"-", "+", "*"},
                            {"-", "*", "+"}, {"*", "-", "+"}, {"*", "+", "-"}};
        
        String num = "";
        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(Character.isDigit(c)) {
                num += c;
            } else {
                queue.offer(num);
                queue.offer(String.valueOf(c));
                num = "";
            }
        }
        queue.offer(num);
        
        for(int i = 0; i < symbols.length; i++) {
            answer = Math.max(answer, express(queue, symbols[i]));
        }
        
        return answer;
    }
}