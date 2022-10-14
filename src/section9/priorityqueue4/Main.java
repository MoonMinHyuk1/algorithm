package section9.priorityqueue4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture> {
    public int pay, day;

    public Lecture(int pay, int day) {
        this.pay = pay;
        this.day = day;
    }

    public int compareTo(Lecture o) {
        return o.day - this.day;
    }
}

public class Main {
    static int n, max = Integer.MIN_VALUE;

    public int solution(ArrayList<Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());

        Collections.sort(arr);
        int j = 0;
        for(int i = max; i >= 1; i--) {
            for(; j < n; j++) {
                if(arr.get(j).day < i) {
                    break;
                }
                PQ.offer(arr.get(j).pay);
            }
            if(!PQ.isEmpty()) {
                answer += PQ.poll();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int pay = sc.nextInt();
            int day = sc.nextInt();
            arr.add(new Lecture(pay, day));
            if(max < day) {
                max = day;
            }
        }
        System.out.println(A.solution(arr));
    }
}
