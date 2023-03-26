import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(Character c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else if(c == ')') {
                if(!stack.isEmpty() && stack.pop() == '(') {
                    continue;
                }
                return false;
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }

        return answer;
    }
}