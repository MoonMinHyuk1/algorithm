package section7.bfscalf8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    int[] dis = {1, -1, 5};
    int[] ch;
    Queue<Integer> queue = new LinkedList<>();

    public int BFS(int s, int e) {
        int answer = 0;
        ch = new int[10001];
        ch[s] = 1;
        queue.offer(s);

        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int x = queue.poll();
                for(int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if(nx == e) {
                        answer++;
                        return answer;
                    }
                    if(nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            answer++;
        }

        return 0;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(A.BFS(s, e));
    }
}
