import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int[][] arr = new int[plans.length][3];
        Stack<int[]> stack = new Stack<>();
        int index = 0;
        
        for(int i = 0; i < plans.length; i++) {
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(plans[i][1].split(":")[0]) * 60 + Integer.parseInt(plans[i][1].split(":")[1]);
            arr[i][2] = Integer.parseInt(plans[i][2]);
        }
        Arrays.sort(arr, (o1, o2) -> (o1[1] - o2[1]));
        stack.push(arr[0]);
        int nowTime = stack.peek()[1];
        for(int i = 1; i < arr.length; i++) {
            int nextTime = arr[i][1];
            while(!stack.isEmpty()) {
                int[] now = stack.pop();
                if(nowTime + now[2] <= nextTime) {
                    nowTime += now[2];
                    answer[index++] = plans[now[0]][0];
                } else {
                    now[2] = nowTime + now[2] - nextTime;
                    nowTime = nextTime;
                    stack.push(now);
                    break;
                }
            }
            stack.push(arr[i]);
            if(stack.size() == 1) {
                nowTime = arr[i][1];
            }
        }
        while(!stack.isEmpty()) {
            answer[index++] = plans[stack.pop()[0]][0];
        }
        
        return answer;
    }
}