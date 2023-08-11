class Solution {
    
    public int findSum(String s, int i, int j, int sum) {
        int dis = 0;
        while(true) {
            if(0 <= i - dis && j + dis < s.length()) {
                if(s.charAt(i - dis) == s.charAt(j + dis)) {
                    sum += 2;
                    dis++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return sum;
    }
    
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++) {
            //홀수인 경우
            int sum = findSum(s, i, i, -1);
            answer = Math.max(answer, sum);
            //짝수인 경우
            sum = findSum(s, i, i + 1, 0);
            answer = Math.max(answer, sum);
            sum = findSum(s, i - 1, i, 0);
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}