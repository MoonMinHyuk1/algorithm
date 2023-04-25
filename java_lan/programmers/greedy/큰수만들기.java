import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < number.length(); i++) {
            while(!stack.isEmpty() && k > 0 && stack.peek() < number.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(number.charAt(i));
        }
        while(k > 0) {
            k--;
            stack.pop();
        }
        while(!stack.isEmpty()) {
            answer = String.valueOf(stack.pop()) + answer;
        }
        
        return answer;
    }
}