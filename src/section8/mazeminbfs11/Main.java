package section8.mazeminbfs11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] G;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = -1;

    public void BFS() {
        Queue<Integer[]> Q = new LinkedList<Integer[]>();

        Integer[] dxy = new Integer[2];
        Integer[] d = {0, 0};
        G[0][0] = 1;
        Q.offer(d);
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                dxy = Q.poll();
                if(dxy[0] == 6 && dxy[1] == 6) {
                    Q.clear();
                    break;
                }
                for(int j = 0; j < 4; j++) {
                    int nx = dxy[0] + dx[j];
                    int ny = dxy[1] + dy[j];
                    if(nx >= 0 && nx < 7 && ny >= 0 && ny < 7) {
                        if(G[nx][ny] == 0) {
                            G[nx][ny] = 1;
                            Integer[] ndxy = {nx, ny};
                            Q.offer(ndxy);
                        }
                    }
                }
            }
            answer++;
        }
        if(dxy[0] != 6 || dxy[1] != 6) {
            answer = -1;
        }
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        G = new int[7][7];
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++) {
                G[i][j] = sc.nextInt();
            }
        }
        A.BFS();
        System.out.println(answer);
    }
}
