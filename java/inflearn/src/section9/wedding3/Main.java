package section9.wedding3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {
    public int time;
    public char state;

    public Time(int time, char state) {
        this.state = state;
        this.time = time;
    }

    @Override
    public int compareTo(Time o) {
        if(this.time == o.time) {
            return this.state - o.state;
        } else {
            return this.time - o.time;
        }
    }
}

public class Main {
    public int solution(ArrayList<Time> arr) {
        int answer = 0, cnt = 0;

        Collections.sort(arr);
        for(Time obj : arr) {
            if(obj.state == 's') {
                cnt++;
            } else {
                cnt--;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int st = sc.nextInt();
            int et = sc.nextInt();
            arr.add(new Time(st, 's'));
            arr.add(new Time(et, 'e'));
        }
        System.out.println(A.solution(arr));
    }
}
