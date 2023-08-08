class Solution {
    
    public boolean collect(int n, int[] times, long time) {
        long sum = 0;
        for(int i = 0; i < times.length; i++) {
            sum += (long) (time / (long) times[i]);
        }
        return (sum >= n) ? true : false;
    }
    
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        long lt = 0, rt = (long) n * times[times.length - 1];
        while(lt <= rt) {
            long mid = (lt + rt) / 2;
            if(collect(n, times, mid)) {
                rt = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                lt = mid + 1;
            }
        }
        
        return answer;
    }
}