import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Integer> index = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < enroll.length; i++) {
            index.put(enroll[i], i);
        }
        for(int i = 0; i < enroll.length; i++) {
            if(!referral[i].equals("-")) {
                map.put(i, index.get(referral[i]));
            } else {
                map.put(i, -1);
            }
        }
        for(int i = 0; i < seller.length; i++) {
            int price = amount[i] * 100;
            int name = index.get(seller[i]);
            while(name != -1) {
                if(price < 10) {
                    answer[name] += price;
                    break;
                }
                int p = price / 10;
                answer[name] += (price - p);
                name = map.get(name);
                price = p;
            }
        }
        
        return answer;
    }
}