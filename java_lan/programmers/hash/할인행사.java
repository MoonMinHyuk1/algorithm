import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < 9; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        int index = 0;
        for(int i = 9; i < discount.length; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
            boolean flag = true;
            for(int j = 0; j < want.length; j++) {
                if(map.get(want[j]) == null || number[j] != map.get(want[j])) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                answer++;
            }
            map.put(discount[index], map.get(discount[index]) - 1);
            index++;
        }
        
        return answer;
    }
}