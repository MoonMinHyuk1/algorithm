class Solution {
    public int solution(int sticker[]) {
        int answer = sticker[0];
        int[] dp1 = new int[sticker.length + 1];
        int[] dp2 = new int[sticker.length + 2];
        
        //첫번째 포함
        for(int i = 0; i < sticker.length - 1; i++) {
            dp1[i + 2] = Math.max(dp1[i] + sticker[i], dp1[i + 1]);
        }
        //첫번째 미포함
        for(int i = 1; i < sticker.length; i++) {
            dp2[i + 2] = Math.max(dp2[i] + sticker[i], dp2[i + 1]);
        }
        answer = Math.max(answer, dp1[dp1.length - 1]);
        answer = Math.max(answer, dp2[dp2.length - 1]);

        return answer;
    }
}