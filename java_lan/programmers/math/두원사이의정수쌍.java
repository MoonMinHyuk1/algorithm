class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int x = 1; x <= r2; x++) {
            long y2 = (long) Math.floor(Math.sqrt(1.0 * r2 * r2 - 1.0 * x * x));
            long y1 = (long) Math.ceil(Math.sqrt(1.0 * r1 * r1 - 1.0 * x * x));
            answer += (y2 - y1 + 1);
        }
        answer *= 4;
        
        return answer;
    }
}