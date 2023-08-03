class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        int[][] g = new int [n][n];
        
        int x = -1, y = 0, num = 1;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(i % 3 == 0) x++;
                else if(i % 3 == 1) y++;
                else {
                    x--; y--;
                }
                g[x][y] = num++;
            }
        }
        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                answer[index++] = g[i][j];
            }
        }
        
        return answer;
    }
}