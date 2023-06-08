package greedy;

import java.util.*;

public class Main5_6 {

    public int solution(int n, int[][] trans, int[][] bookings){
        int answer = 0;
        int[] arr = new int[n + 1];
        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 0; i < trans.length; i++) {
            for(int j = trans[i][0]; j < trans[i][1]; j++) {
                arr[j] += trans[i][2];
            }
        }
        Arrays.sort(bookings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] == o2[0]) ? (o1[1] - o2[1]) : (o1[0] - o2[0]);
            }
        });
        int index = 0;
        for(int i = 1; i < arr.length; i++) {
            while(!list.isEmpty() && list.peek() == i) {
                list.poll();
            }
            for(int j = index; j < bookings.length; j++) {
                if(bookings[j][0] > i) {
                    index = j;
                    break;
                }
                if(bookings[j][0] == i) {
                    list.offer(bookings[j][1]);
                    answer++;
                }
            }
            Collections.sort(list);
            while(list.size() > arr[i]) {
                list.pollLast();
                answer--;
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
