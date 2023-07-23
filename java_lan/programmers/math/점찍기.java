class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        long max = (long) d;
        for(long i = 0; i <= max; i += k) {
            long x = (long) Math.sqrt((max * max) - (i * i));
            answer += ((x / k) + 1);
        }
        
        return answer;
    }
}