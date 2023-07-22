class Solution {
    
    public int rotation(int[][] arr, int x1, int y1, int x2, int y2) {
        int min = arr[x1][y1];
        
        int prev = arr[x1][y1];
        for(int i = y1 + 1; i <= y2; i++) {
            int now = arr[x1][i];
            arr[x1][i] = prev;
            prev = now;
            min = Math.min(min, prev);
        }
        for(int i = x1 + 1; i <= x2; i++) {
            int now = arr[i][y2];
            arr[i][y2] = prev;
            prev = now;
            min = Math.min(min, prev);
        }
        for(int i = y2 - 1; i >= y1; i--) {
            int now = arr[x2][i];
            arr[x2][i] = prev;
            prev = now;
            min = Math.min(min, prev);
        }
        for(int i = x2 - 1; i >= x1; i--) {
            int now = arr[i][y1];
            arr[i][y1] = prev;
            prev = now;
            min = Math.min(min, prev);
        }
        
        return min;
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows][columns];
        
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (arr[i].length * i) + j + 1;
            }
        }
        for(int i = 0; i < queries.length; i++) {
            answer[i] = rotation(arr, queries[i][0] - 1, queries[i][1] - 1, queries[i][2] - 1, queries[i][3] - 1);
        }
        
        return answer;
    }
}