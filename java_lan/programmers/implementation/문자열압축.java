class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        for(int len = 1; len <= s.length(); len++) {
            String slice = s.substring(0, len);
            String result = "";
            int cnt = 1;
            for(int i = len; i < s.length(); i += len) {
                int endIndex = Math.min(i + len, s.length());
                if(slice.equals(s.substring(i, endIndex))) {
                    cnt++;
                } else {
                    result += ((cnt == 1) ? "" : cnt);
                    result += slice;
                    slice = s.substring(i, endIndex);
                    cnt = 1;
                }
            }
            result += ((cnt == 1) ? "" : cnt);
            result += slice;
            answer = Math.min(answer, result.length());
        }
        
        return answer;
    }
}