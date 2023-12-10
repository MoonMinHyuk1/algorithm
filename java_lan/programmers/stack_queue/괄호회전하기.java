import java.util.*;

class Solution {
    
    public boolean check(char[] arr, int index) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = index; i < arr.length; i++) {
            char c = arr[i];
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if(c == ')') {
                if(stack.isEmpty() || (!stack.isEmpty() && stack.pop() != '(')) {
                    return false;
                }
            } else if(c == '}') {
                if(stack.isEmpty() || (!stack.isEmpty() && stack.pop() != '{')) {
                    return false;
                }
            } else if(c == ']') {
                if(stack.isEmpty() || (!stack.isEmpty() && stack.pop() != '[')) {
                    return false;
                }
            }
        }
        for(int i = 0; i < index; i++) {
            char c = arr[i];
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if(c == ')') {
                if(stack.isEmpty() || (!stack.isEmpty() && stack.pop() != '(')) {
                    return false;
                }
            } else if(c == '}') {
                if(stack.isEmpty() || (!stack.isEmpty() && stack.pop() != '{')) {
                    return false;
                }
            } else if(c == ']') {
                if(stack.isEmpty() || (!stack.isEmpty() && stack.pop() != '[')) {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
        
        return true;
    }
    
    public int solution(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        
        for(int i = 0; i < arr.length; i++) {
            if(check(arr, i)) {
                answer++;
            }
        }
        
        return answer;
    }
}