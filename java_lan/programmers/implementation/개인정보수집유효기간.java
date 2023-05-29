import java.util.*;

class Solution {
    
    public int getDay(String str) {
        int year = Integer.valueOf(str.split("\\.")[0]) - 2000;
        int month = Integer.valueOf(str.split("\\.")[1]);
        int day = Integer.valueOf(str.split("\\.")[2]);
        
        return (year * 12 * 28) + (month * 28) + day;
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        int todayInt = getDay(today);
        for(int i = 0; i < terms.length; i++) {
            map.put(terms[i].split(" ")[0], Integer.valueOf(terms[i].split(" ")[1]) * 28);
        }
        for(int i = 0; i < privacies.length; i++) {
            int day = getDay(privacies[i].split(" ")[0]);
            day += map.get(privacies[i].split(" ")[1]);
            if(todayInt >= day) {
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] = i + 1;
            }
        }
        
        return answer;
    }
}