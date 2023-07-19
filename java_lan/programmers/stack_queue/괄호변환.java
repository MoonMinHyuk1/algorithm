import java.util.*;

class Solution {
    
    public boolean collect(String str) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(') {
                stack.push(c);
            } else if(c == ')') {
                if(stack.isEmpty()) return false;
                else if(stack.peek() == '(') stack.pop();
                else if(stack.peek() == ')') return false;
            }
        }
        if(!stack.isEmpty()) return false;
        
        return true;
    }
    
    public int findIndex(String str) {
        int left = 0;
        int right = 0;
        
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') left++;
            else right++;
            if(left == right) {
                return i;
            }
        }
        
        return str.length();
    }
    
    public String dfs(String w) {
        if(w.length() == 0) return "";
        
        int index = findIndex(w);
        String u = w.substring(0, index + 1);
        String v = w.substring(index + 1);
        
        if(collect(u)) {
            return u + dfs(v);
        } else {
            String str = "(" + dfs(v) + ")";
            u = u.substring(1, u.length() - 1);
            for(int i = 0; i < u.length(); i++) {
                char c = (u.charAt(i) == '(') ? ')' : '(';
                str += c;
            }
            return str;
        }
    }
    
    public String solution(String p) {
        String answer = "";
        
        answer = dfs(p);
        
        return answer;
    }
}