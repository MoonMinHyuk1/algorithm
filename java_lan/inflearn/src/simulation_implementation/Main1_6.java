package simulation_implementation;

public class Main1_6 {

    public int findMinIndex(int[] arr) {
        int index = 0;
        int min = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(min > arr[i]) {
                min = arr[i];
                index = i;
            }
        }

        return index;
    }

    public boolean validateMin(int[] arr) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(min > arr[i]) {
                count = 0;
                min = arr[i];
            } else if(min == arr[i]) {
                count++;
            }
        }

        return count == 0;
    }

    public int solution(int[][] fruit){
        int answer = 0;
        int n = fruit.length;
        boolean[] ch = new boolean[n];

        for(int i = 0; i < n - 1; i++) {
            if(ch[i] || !validateMin(fruit[i])) continue;
            for(int j = i + 1; j < n; j++) {
                if(ch[j] || !validateMin(fruit[j])) continue;
                int stuIndex1 = findMinIndex(fruit[i]);
                int stuIndex2 = findMinIndex(fruit[j]);
                if((stuIndex1 != stuIndex2) && (fruit[i][stuIndex2] > 0) && (fruit[j][stuIndex1] > 0) &&
                        (fruit[i][stuIndex1] + 1 <= fruit[i][stuIndex2] - 1) && (fruit[j][stuIndex2] + 1 <= fruit[j][stuIndex1] - 1)) {
                    fruit[i][stuIndex1]++;
                    fruit[i][stuIndex2]--;
                    fruit[j][stuIndex2]++;
                    fruit[j][stuIndex1]--;
                    ch[j] = true;
                    break;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            int index = findMinIndex(fruit[i]);
            answer += fruit[i][index];
        }

        return answer;
    }

    public static void main(String[] args){
        Main1_6 T = new Main1_6();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
