import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);
            while(stack.size() >= 4 && stack.peek() == 1) {
                int[] arr = new int[4];
                for(int j = 0; j < 4; j++) {
                    arr[3 - j] = stack.pop();
                }
                if(arr[0] == 1 && arr[1] == 2 && arr[2] == 3 && arr[3] == 1) {
                    answer++;
                } else {
                    for(int j = 0; j < 4; j++) {
                        stack.push(arr[j]);
                    }
                    break;
                }
            }
        }
        
        return answer;
    }
}