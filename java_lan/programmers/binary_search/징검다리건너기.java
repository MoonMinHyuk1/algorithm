class Solution {
    
    public boolean collect(int[] stones, int k, int user) {
        int sum = 0, max = 0;
        for(int i = 0; i < stones.length; i++) {
            if(stones[i] < user) {
                sum++;
            } else {
                max = Math.max(max, sum);
                sum = 0;
            }
        }
        max = Math.max(max, sum);
        return (max < k) ? true : false;
    }
    
    public int solution(int[] stones, int k) {
        int answer = 0;
        int lt = 0, rt = 0;
        
        for(int i = 0; i < stones.length; i++) {
            rt = Math.max(rt, stones[i]);
        }
        while(lt <= rt) {
            int mid = (rt + lt) / 2;
            if(collect(stones, k, mid)) {
                lt = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                rt = mid - 1;
            }
        }
        
        return answer;
    }
}