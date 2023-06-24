class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int same = 1, diff = 0;
        char now = s.charAt(0);
        boolean flag = false;
        for(int i = 1; i < s.length(); i++) {
            if(flag) {
                same = 1;
                diff = 0;
                now = s.charAt(i);
                flag = false;
                continue;
            }
            if(now == s.charAt(i)) {
                same++;
            } else {
                diff++;
            }
            if(same == diff) {
                answer++;
                flag = true;
            }
        }
        if(!flag) {
            answer++;
        }
        
        return answer;
    }
}