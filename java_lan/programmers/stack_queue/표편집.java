import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        
        for(String str: cmd) {
            String[] arr = str.split(" ");
            switch(arr[0]) {
                case "D":
                    k += Integer.parseInt(arr[1]);
                    break;
                case "U":
                    k -= Integer.parseInt(arr[1]);
                    break;
                case "C":
                    stack.push(k);
                    if(k == n - 1) k--;
                    n--;
                    break;
                case "Z":
                    int i = stack.pop();
                    if(i <= k) k++;
                    n++;
                    break;
            }
        }
        for(int i = 0; i < n; i++) {
            sb.append("O");
        }
        while(!stack.isEmpty()) {
            sb.insert(stack.pop(), "X");
        }
        answer = sb.toString();
        
        return answer;
    }
}