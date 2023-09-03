package re;

public class Main1_6 {

    boolean[] visited;

    public int findMin(int[] arr) {
        int min = Math.min(arr[0], arr[1]);
        min = Math.min(min, arr[2]);
        return min;
    }

    public int exchange(int[][] fruit, int i, int j) {
        if(fruit[i][0] == fruit[i][1] || fruit[i][1] == fruit[i][2] || fruit[i][0] == fruit[i][2]) return 0;
        if(fruit[j][0] == fruit[j][1] || fruit[j][1] == fruit[j][2] || fruit[j][0] == fruit[j][2]) return 0;
        int mini1 = findMin(fruit[i]);
        int minj1 = findMin(fruit[j]);
        int givei = 0, givej = 0, receivei = 0, receivej = 0;
        for(int k = 0; k < 3; k++) {
            if(mini1 == fruit[i][k]) {
                receivei = k;
                givej = k;
            }
            if(minj1 == fruit[j][k]) {
                receivej = k;
                givei = k;
            }
        }
        fruit[i][receivei]++;
        fruit[i][givei]--;
        fruit[j][receivej]++;
        fruit[j][givej]--;
        int mini2 = findMin(fruit[i]);
        int minj2 = findMin(fruit[j]);

        if(mini1 < mini2 && minj1 < minj2) {
            visited[i] = true;
            visited[j] = true;
            return mini2 + minj2;
        } else {
            fruit[i][receivei]--;
            fruit[i][givei]++;
            fruit[j][receivej]--;
            fruit[j][givej]++;
            return 0;
        }
    }

    public int solution(int[][] fruit){
        int answer = 0;
        visited = new boolean[fruit.length];

        for(int i = 0; i < fruit.length; i++) {
            for(int j = i + 1; j < fruit.length; j++) {
                if(visited[i] || visited[j]) continue;
                int cnt = exchange(fruit, i, j);
                if(cnt > 0) {
                    answer += cnt;
                    break;
                }
            }
        }
        for(int i = 0; i < fruit.length; i++) {
            if(!visited[i]) {
                answer += findMin(fruit[i]);
            }
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
