class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        
        int max = Math.max(a, b), min = Math.min(a, b);
        while(true) {
            answer++;
            if(max % 2 == 0 && max - min == 1) {
                break;
            }
            max = (max % 2 == 0) ? (max / 2) : (max / 2 + 1);
            min = (min % 2 == 0) ? (min / 2) : (min / 2 + 1);
        }

        return answer;
    }
}