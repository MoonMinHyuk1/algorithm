class Solution {
    
    public long findSum(int[] arr) {
        long[] sum = new long[arr.length];
        long max = arr[0], min = Integer.MAX_VALUE;
        int index = 0;
        
        sum[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
            if(max < sum[i]) {
                max = sum[i];
                index = i;
            }
        }
        for(int i = index - 1; i >= 0; i--) {
            min = Math.min(min, sum[i]);
        }
        
        return (min < 0) ? (max - min) : max;
    }
    
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;
        
        int[] arr = new int[sequence.length];
        int p = 1;
        for(int i = 0; i < sequence.length; i++) {
            arr[i] = sequence[i] * p;
            p *= -1;
        }
        answer = Math.max(answer, findSum(arr));
        p = -1;
        for(int i = 0; i < sequence.length; i++) {
            arr[i] = sequence[i] * p;
            p *= -1;
        }
        answer = Math.max(answer, findSum(arr));
        
        return answer;
    }
}