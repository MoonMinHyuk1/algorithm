import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        for(int i = 0; i < callings.length; i++) {
            int index = map.get(callings[i]);
            int preIndex = map.get(players[index - 1]);
            map.put(players[index], preIndex);
            map.put(players[preIndex], index);
            String temp = players[index];
            players[index] = players[preIndex];
            players[preIndex] = temp;
        }
        
        return players;
    }
}