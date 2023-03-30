package java_lan.programmers;

import java.util.*;
import java.io.*;

public class Test {
    static class Rec {
        int xs, xe, ys, ye;
        
        public Rec(int xs, int xe, int ys, int ye) {
            this.xs = xs;
            this.xe = xe;
            this.ys = ys;
            this.ye = ye;
        }
    }
    
    static class Point {
        int x, y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    int answer;
    List<Rec> recs;
    boolean[][] visited;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public boolean ch(int x, int y) {
        if(x < 1 || x >= 101 || y < 1 || y >= 101) {
            return false;
        }
        if(visited[x][y]) {
            return false;
        }
        for(Rec rec : recs) {
            if(rec.xs < x && x < rec.xe && rec.ys < y && y < rec.ye) {
                return false;
            }
        }
        boolean check = false;
        for(Rec rec : recs) {
            if(rec.xs <= x && x <= rec.xe && rec.ys <= y && y <= rec.ye) {
                check = true;
                break;
            }
        }
        
        if(check) {
            return true;
        } else {
            return false;
        }
    }
    
    public void bfs(int cx, int cy, int ix, int iy) {
        Queue<Point> queue = new LinkedList<>();
        
        queue.offer(new Point(cx, cy));
        visited[cx][cy] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Point now = queue.poll();
                if(now.x == ix && now.y == iy) {
                    answer /= 2;
                    return;
                }
                for(int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    if(ch(nx, ny)) {
                        queue.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
            answer++;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        answer = 0;
        recs = new ArrayList<>();
        visited = new boolean[101][101];
        
        int cx = 2 * characterX;
        int cy = (characterY - characterX + 1) * 2 + cx - 1;
        int ix = 2 * itemX;
        int iy = (itemY - itemX + 1) * 2 + ix - 1;
        for(int i = 0; i < rectangle.length; i++) {
            int xs = 2 * rectangle[i][0];
            int xe = xs + (rectangle[i][2] - rectangle[i][0]) * 2;
            int ys = 2 * rectangle[i][1];
            int ye = ys + (rectangle[i][3] - rectangle[i][1]) * 2;
            recs.add(new Rec(xs, xe, ys, ye));
            System.out.println(xs + " " + ys + " " + xe + " " + ye);
        }
        bfs(cx, cy, ix, iy);
        
        return answer;
    }

    public static void main(String[] args) {
        Test test = new Test();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // String[] arr = {"a", "b", "c"};
        // List<String> l = new ArrayList<>(Arrays.asList());
        // l.stream().map(a -> map.put(a, new ArrayList<>()));

        // int[] arr = {1, 2, 3};
        // Arrays.stream(arr).forEach(n -> {
            
        // });

        int[][] rec = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
        int cx = 1, cy = 3, ix = 7, iy = 8;
        System.out.println(test.solution(rec, cx, cy, ix, iy));
    }
}
