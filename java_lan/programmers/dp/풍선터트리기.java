class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int min = a[0], index = 0;
        
        for(int i = 0; i < a.length; i++) {
            if(a[i] < min) {
                min = a[i];
                index = i;
            }
        }
        answer++;
        int smin = Integer.MAX_VALUE;
        for(int i = 0; i < index; i++) {
            if(a[i] < smin) {
                smin = a[i];
                answer++;
            }
        }
        smin = Integer.MAX_VALUE;
        for(int i = a.length - 1; i > index; i--) {
            if(a[i] < smin) {
                smin = a[i];
                answer++;
            }
        }
        
        return answer;
    }
}