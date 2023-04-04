class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int w = yellow; w >= 1; w--) {
            if(yellow % w == 0) {
                int h = yellow / w;
                if((2 * h) + (2 * w) + 4 == brown) {
                    answer[0] = w + 2;
                    answer[1] = h + 2;
                    break;
                }
            }
        }
        
        return answer;
    }
}