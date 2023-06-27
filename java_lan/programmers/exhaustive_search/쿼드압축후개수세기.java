import java.util.*;

class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        LinkedList<int[]> list = new LinkedList<>();

        list.offer(new int[]{0, arr.length, 0, arr.length});
        while(!list.isEmpty()) {
            int size = list.size();
            for(int i = 0; i < size; i++) {
                int[] now = list.poll();
                int xs = now[0], xe = now[1], ys = now[2], ye = now[3];
                int n = arr[xs][ys];
                boolean flag = true;
                for(int j = xs; j < xe; j++) {
                    for(int k = ys; k < ye; k++) {
                        if(arr[j][k] != n) {
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag) {
                    answer[n]++;
                } else {
                    if(xe - xs == 1) {
                        answer[n]++;
                        continue;
                    }
                    list.offer(new int[]{xs, (xe + xs) / 2, ys, (ye + ys) / 2});
                    list.offer(new int[]{xs, (xe + xs) / 2, (ye + ys) / 2, ye});
                    list.offer(new int[]{(xe + xs) / 2, xe, ys, (ye + ys) / 2});
                    list.offer(new int[]{(xe + xs) / 2, xe, (ye + ys) / 2, ye});
                }
            }
        }

        return answer;
    }
}