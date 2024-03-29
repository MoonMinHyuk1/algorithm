package re;

import java.util.*;

public class Main5_6 {

    public int solution(int n, int[][] trains, int[][] bookings){
        int answer=0;
        int[] sum = new int[n + 1];

        for(int i = 0; i < trains.length; i++) {
            sum[trains[i][0]] += trains[i][2];
            sum[trains[i][1]] -= trains[i][2];
        }
        for(int i = 1; i < sum.length; i++) {
            sum[i] += sum[i - 1];
        }
        Arrays.sort(bookings, (o1, o2) -> (o1[0] - o2[0]));
        LinkedList<Integer> list = new LinkedList<>();
        int index = 0;
        for(int i = 1; i < sum.length; i++) {
            while(!list.isEmpty() && list.peek() == i) {
                answer++;
                list.poll();
            }
            while(index < bookings.length && i == bookings[index][0]) {
                list.offer(bookings[index][1]);
                index++;
            }
            Collections.sort(list);
            while(sum[i] < list.size()) {
                list.pollLast();
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Main5_6 T = new Main5_6();
        System.out.println(T.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
        System.out.println(T.solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}}));
        System.out.println(T.solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
        System.out.println(T.solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}}));
        System.out.println(T.solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}}));
    }
}
