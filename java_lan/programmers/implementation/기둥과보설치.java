import java.util.*;

class Solution {
    
    public boolean pillarCheck(boolean[][] pillar, boolean[][] floor, int x, int y) {
        if(y == 0 || pillar[x][y - 1] || floor[x][y] || (x > 0 && floor[x - 1][y])) {
            return true;
        }
        return false;
    }
    
    public boolean floorCheck(boolean[][] pillar, boolean[][] floor, int x, int y) {
        int n = pillar.length - 1;
        if(y > 0 && (pillar[x][y - 1] || (x < n && pillar[x + 1][y - 1]))) {
            return true;
        } else if((0 < x && x < n) && (floor[x - 1][y] && floor[x + 1][y])) {
            return true;
        }
        return false;
    }
    
    public boolean check(int n, boolean[][] pillar, boolean[][] floor) {
        for(int i = 0; i < pillar.length; i++) {
            for(int j = 0; j < pillar.length; j++) {
                //기둥 검사
                if(pillar[i][j] && !pillarCheck(pillar, floor, i, j)) {
                    return false;
                }
                //보 검사
                if(floor[i][j] && !floorCheck(pillar, floor, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        boolean[][] pillar = new boolean[n + 1][n + 1];
        boolean[][] floor = new boolean[n + 1][n + 1];
        int index = 0;
        
        for(int[] arr: build_frame) {
            int x = arr[0], y = arr[1];
            if(arr[2] == 0 && arr[3] == 1) { //기둥 설치
                if(pillarCheck(pillar, floor, x, y)) {
                    pillar[x][y] = true;
                    index++;
                }
            } else if(arr[2] == 1 && arr[3] == 1) { //보 설치
                if(floorCheck(pillar, floor, x, y)) {
                    floor[x][y] = true;
                    index++;
                }
            } else if(arr[2] == 0 && arr[3] == 0) { //기둥 삭제
                pillar[x][y] = false;
                if(!check(n, pillar, floor)) {
                    pillar[x][y] = true;
                    continue;
                }
                index--;
            } else if(arr[2] == 1 && arr[3] == 0) { //보 삭제
                floor[x][y] = false;
                if(!check(n, pillar, floor)) {
                    floor[x][y] = true;
                    continue;
                }
                index--;
            }
        }
        answer = new int[index][3];
        index = 0;
        for(int i = 0; i < pillar.length; i++) {
            for(int j = 0; j < pillar.length; j++) {
                if(pillar[i][j]) {
                    answer[index++] = new int[]{i, j, 0};
                }
            }
        }
        for(int i = 0; i < floor.length; i++) {
            for(int j = 0; j < floor.length; j++) {
                if(floor[i][j]) {
                    answer[index++] = new int[]{i, j, 1};
                }
            }
        }
        Arrays.sort(answer, (o1, o2) -> (
            (o1[0] == o2[0] && o1[1] == o2[1]) ? (o1[2] - o2[2]) : (
                (o1[0] == o2[0]) ? (o1[1] - o2[1]) : (o1[0] - o2[0])
            )
        ));
        
        return answer;
    }
}