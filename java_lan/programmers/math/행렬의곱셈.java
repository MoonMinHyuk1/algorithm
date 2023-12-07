import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i = 0; i < answer.length; i++) {
            for(int j = 0; j < answer[i].length; j++) {
                List<Integer> list1 = new ArrayList<>();
                List<Integer> list2 = new ArrayList<>();
                for(int k = 0; k < arr1[i].length; k++) {
                    list1.add(arr1[i][k]);
                }
                for(int k = 0; k < arr2.length; k++) {
                    list2.add(arr2[k][j]);
                }
                int sum = 0;
                for(int k = 0; k < list1.size(); k++) {
                    sum += (list1.get(k) * list2.get(k));
                }
                answer[i][j] = sum;
            }
        }
        
        return answer;
    }
}