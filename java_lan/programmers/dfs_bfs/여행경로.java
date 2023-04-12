import java.util.*;

class Solution {
    String[] answer;
    boolean[] visited;
    List<String> result;
    
    public void dfs(int level, String start, String[][] tickets) {
        if (answer.length == tickets.length + 1) {
            return;
        }
        if (level == tickets.length) {
            if (result.size() == tickets.length) {
                answer = new String[result.size() + 1];
                answer[0] = "ICN";
                for(int i = 1; i < answer.length; i++) {
                    answer[i] = result.get(i - 1);
                }
            }
            return;
        }
        for(int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                result.add(tickets[i][1]);
                dfs(level + 1, tickets[i][1], tickets);
                result.remove(result.size() - 1);
                visited[i] = false;
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        answer = new String[0];
        visited = new boolean[tickets.length];
        result = new ArrayList<>();
        
        // Arrays.sort(tickets, (o1, o2) -> o1[0] == o2[0] ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]));
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].toString().contentEquals(o2[0].toString())) {
                    return o1[1].toString().compareTo(o2[1].toString());
                }
                else {
                    return o1[0].toString().compareTo(o2[0].toString());
                }
            }
        });
        dfs(0, "ICN", tickets);
        
        return answer;
    }
}