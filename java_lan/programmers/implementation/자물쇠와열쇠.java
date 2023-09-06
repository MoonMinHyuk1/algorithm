import java.util.*;

class Solution {
    
    int minx, miny, maxx, maxy, lenx, leny;
    
    public int[][] rotation(int[][] key) {
        int[][] arr = new int[key.length][key[0].length];
        
        int x = 0;
        for(int i = 0; i < arr[0].length; i++) {
            int y = 0;
            for(int j = arr.length - 1; j >= 0; j--) {
                arr[x][y] = key[j][i];
                y++;
            }
            x++;
        }
        
        return arr;
    }
    
    public boolean collect(int[][] key, int[][] arr) {
        for(int i = 0; i <= key.length - arr.length; i++) {
            for(int j = 0; j <= key[0].length - arr[0].length; j++) {
                boolean flag = true;
                for(int k = 0; k < arr.length; k++) {
                    for(int l = 0; l < arr[0].length; l++) {
                        if(arr[k][l] == key[k + i][l + j]) flag = false;
                    }
                }
                if(flag) return flag;
            }
        }
        return false;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        minx = 20; miny = 20; maxx = 0; maxy = 0;
        
        for(int i = 0; i < lock.length; i++) {
            for(int j = 0; j < lock[i].length; j++) {
                if(lock[i][j] == 0) {
                    minx = Math.min(minx, i);
                    maxx = Math.max(maxx, i);
                    miny = Math.min(miny, j);
                    maxy = Math.max(maxy, j);
                }
            }
        }
        lenx = maxx - minx; leny = maxy - miny;
        if(lenx == -20 || leny == -20) return true;
        int[][] arr = new int[lenx + 1][leny + 1];
        for(int i = 0; i < arr.length; i++) Arrays.fill(arr[i], 1);
        for(int i = 0; i < lock.length; i++) {
            for(int j = 0; j < lock[i].length; j++) {
                if(lock[i][j] == 0) {
                    arr[i - minx][j - miny] = 0;
                }
            }
        }
        for(int i = 0; i < 4; i++) {
            if(collect(key, arr)) return true;
            key = rotation(key);
        }
        
        return answer;
    }
}