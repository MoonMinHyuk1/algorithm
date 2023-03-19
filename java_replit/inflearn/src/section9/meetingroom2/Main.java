package section9.meetingroom2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {
    public int s, e;

    public Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time o) {
        if(this.e == o.e) {
            return this.s - o.s;
        } else {
            return this.e - o.e;
        }
    }
}

public class Main {
    public int solution(ArrayList<Time> arr) {
        int cnt = 0;
        Collections.sort(arr);
        int et = 0;

        for(Time ob : arr) {
            if(ob.s >= et) {
                cnt++;
                et = ob.e;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr.add(new Time(s, e));
        }

        System.out.println(A.solution(arr));
    }
}
