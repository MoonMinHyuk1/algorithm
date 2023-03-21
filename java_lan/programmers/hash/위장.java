import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String[] wear : clothes) {
            map.put(wear[1], map.getOrDefault(wear[1], new ArrayList<>()));
            map.get(wear[1]).add(wear[0]);
        }
        for(String key : map.keySet()) {
            answer *= (map.get(key).size() + 1);
        }
        answer -= 1;
        
        return answer;
    }

    // 조합(시간초과)
    // int answer = 0;
    // HashMap<String, List<String>> map;
    // List<String> type;
    
    // public void combination(int level, int n, int index, int size, int mul) {
    //     if(level == n) {
    //         answer += mul;
    //         return;
    //     }
    //     for(int i = index; i < size; i++) {
    //         combination(level + 1, n, i + 1, size, mul * map.get(type.get(i)).size());
    //     }
    // }
    
    // public int solution(String[][] clothes) {
    //     map = new HashMap<>();
        
    //     for(String[] wear : clothes) {
    //         map.put(wear[1], map.getOrDefault(wear[1], new ArrayList<>()));
    //         map.get(wear[1]).add(wear[0]);
    //     }
    //     type = new ArrayList<>(map.keySet());
        
    //     for(int n = 1; n <= map.size(); n++) {
    //         combination(0, n, 0, map.size(), 1);
    //     }
        
    //     return answer;
    // }
}