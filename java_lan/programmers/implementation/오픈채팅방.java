import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        
        for(String str: record) {
            String[] arr = str.split(" ");
            if(arr[0].equals("Enter")) {
                queue.offer(arr[1] + " E");
                map.put(arr[1], arr[2]);
            } else if(arr[0].equals("Leave")) {
                queue.offer(arr[1] + " L");
            } else if(arr[0].equals("Change")) {
                map.put(arr[1], arr[2]);
            }
        }
        answer = new String[queue.size()];
        int index = 0;
        while(!queue.isEmpty()) {
            String str = queue.poll();
            String[] arr = str.split(" ");
            String name = map.get(arr[0]);
            if(arr[1].equals("E")) {
                answer[index++] = name + "님이 들어왔습니다.";
            } else if(arr[1].equals("L")) {
                answer[index++] = name + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}