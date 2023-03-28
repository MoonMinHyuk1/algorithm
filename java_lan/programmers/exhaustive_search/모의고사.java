import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[][] abc = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int score[] = {0, 0, 0};
        int index[] = {0, 0, 0};
        int maxIndex[] = {5, 8, 10};
        
        for(int i = 0; i < answers.length; i++) {
            for(int j = 0; j < 3; j++) {
                score[j] = (answers[i] == abc[j][index[j]]) ? (score[j] + 1) : score[j];
                index[j] = (index[j] + 1 == maxIndex[j]) ? 0 : index[j] + 1;
            }
        }
        int maxScore = 0;
        for(int s : score) {
            maxScore = (s > maxScore) ? s : maxScore;
        }
        for(int i = 0; i < 3; i++) {
            if(score[i] == maxScore) {
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] = i + 1;
            }
        }
        
        return answer;
    }
}