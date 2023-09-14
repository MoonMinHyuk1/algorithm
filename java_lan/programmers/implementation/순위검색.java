import java.util.*;

class Solution {
    
    public void addStr(Queue<String> queue, String ... string) {
        int size = queue.size();
        for(int j = 0; j < size; j++) {
            String str = queue.poll();
            for(String s: string) {
                queue.offer(str + s);
            }
        }
    }
    
    public int binary(List<Integer> list, int score) {
        int lt = 0, rt = list.size() - 1;
        
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(list.get(mid) < score) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        
        return list.size() - lt;
    }
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < info.length; i++) {
            String[] split = info[i].split(" ");
            String str = "";
            for(int j = 0; j < 4; j++) {
                str += split[j];
            }
            map.putIfAbsent(str, new ArrayList<>());
            map.get(str).add(Integer.parseInt(split[4]));
        }
        for(List<Integer> list: map.values()) {
            Collections.sort(list);
        }
        for(int i = 0; i < query.length; i++) {
            String[] split = query[i].split(" ");
            Queue<String> queue = new LinkedList<>();
            if(split[0].equals("-")) {
                queue.offer("java");
                queue.offer("python");
                queue.offer("cpp");
            } else {
                queue.offer(split[0]);
            }
            if(split[2].equals("-")) {
                addStr(queue, "backend", "frontend");
            } else {
                addStr(queue, split[2]);
            }
            if(split[4].equals("-")) {
                addStr(queue, "junior", "senior");
            } else {
                addStr(queue, split[4]);
            }
            if(split[6].equals("-")) {
                addStr(queue, "chicken", "pizza");
            } else {
                addStr(queue, split[6]);
            }
            int score = Integer.parseInt(split[7]);
            while(!queue.isEmpty()) {
                String str = queue.poll();
                if(map.get(str) != null) {
                    answer[i] += binary(map.get(str), score);
                }
            }
        }
        
        return answer;
    }
}