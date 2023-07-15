class Solution {
    
    public long find(long n) {
        long block = 1;
        long sqrt = (long) Math.sqrt(n);
        
        if(n == 1) {
            return 0;
        }
        for(long i = 2; i <= sqrt; i++) {
            if((n % i == 0)) {
                if((i <= 10000000) && (n / i <= 10000000)) {
                    block = Math.max(block, Math.max(i, n / i));
                } else if(i <= 10000000) {
                    block = Math.max(block, i);
                } else if(n / i <= 10000000) {
                    block = Math.max(block, n / i);
                }
            }
        }
        
        return block;
    }
    
    public int[] solution(long begin, long end) {
        int length = (int) end - (int) begin + 1;
        int[] answer = new int[length];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = (int) (find(begin + i));
        }
        
        return answer;
    }
}