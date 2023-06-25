import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> reporters = new HashMap<>();
        
        for(int i = 0; i < report.length; i++) {
            String reporter = report[i].split(" ")[0];
            String reportee = report[i].split(" ")[1];
            map.putIfAbsent(reportee, new HashSet<>());
            map.get(reportee).add(reporter);
        }
        for(String key: map.keySet()) {
            if(map.get(key).size() >= k) {
                for(String value: map.get(key)) {
                    reporters.put(value, reporters.getOrDefault(value, 0) + 1);
                }
            }
        }
        for(int i = 0; i < id_list.length; i++) {
            answer[i] = reporters.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
}