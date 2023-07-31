import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        col--; row_begin--; row_end--;
        final int c = col;
        Arrays.sort(data, (o1, o2) -> ((o1[c] == o2[c]) ? (o2[0] - o1[0]) : (o1[c] - o2[c])));
        for(int i = row_begin; i <= row_end; i++) {
            int sum = 0;
            for(int j = 0; j < data[i].length; j++) {
                sum += (data[i][j] % (i + 1));
            }
            answer = answer ^ sum;
        }
        
        return answer;
    }
}