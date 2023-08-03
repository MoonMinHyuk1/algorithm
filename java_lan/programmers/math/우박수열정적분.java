import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> list = new ArrayList<>();
        
        while(k != 1) {
            list.add(k);
            if(k % 2 == 0) k /= 2;
            else k = k * 3 + 1;
        }
        list.add(k);
        double[] arr = new double[list.size() - 1];
        for(int i = 0; i < list.size() - 1; i++) {
            int x1 = list.get(i), x2 = list.get(i + 1);
            double min = Double.valueOf(Math.min(x1, x2));
            double max = Double.valueOf(Math.max(x1, x2));
            arr[i] = min;
            arr[i] += ((max - min) / 2);
        }
        for(int i = 0; i < ranges.length; i++) {
            ranges[i][1] += arr.length;
            if(ranges[i][0] <= ranges[i][1]) {
                for(int j = ranges[i][0]; j < ranges[i][1]; j++) {
                    answer[i] += arr[j];
                }
            } else {
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}