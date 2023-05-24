package hash_parsing;

import java.util.*;

public class Main2_6 {

    static class Info implements Comparable<Info> {
        String name;
        int time;

        public Info(String name, String time) {
            this.name = name;
            int minute = Integer.valueOf(time.split(":")[0]);
            int second = Integer.valueOf(time.split(":")[1]);
            this.time = minute * 60 + second;
        }

        @Override
        public int compareTo(Info info) {
            return this.time - info.time;
        }
    }

    public void refactor(String[] reports, String times) {
        List<Info> infoList = new ArrayList<>();
        PriorityQueue<Info> infoPQ = new PriorityQueue<>();

        for(String str: reports) {
            String name = str.split(" ")[0];
            String time = str.split(" ")[1];
            Info info = new Info(name, time);
            infoList.add(info);
            infoPQ.offer(info);
        }
        Info start = new Info("start", times.split(" ")[0]);
        Info end = new Info("end", times.split(" ")[1]);

        Collections.sort(infoList);
        for(Info info: infoList) {
            if(start.time <= info.time && info.time <= end.time) {
                System.out.print(info.name + " ");
            }
        }
        System.out.println();
        for(Info info: infoPQ) {
            if(start.time <= info.time && info.time <= end.time) {
                System.out.print(info.name + " ");
            }
        }
        System.out.println();
    }

    public String[] solution(String[] reports, String times){
        String[] answer = {};
        String[][] info = new String[reports.length][2];

        for(int i = 0; i < reports.length; i++) {
            info[i][0] = reports[i].split(" ")[0];
            info[i][1] = reports[i].split(" ")[1];
        }
        Arrays.sort(info, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });
        String start = times.split(" ")[0];
        String end = times.split(" ")[1];
        for(int i = 0; i < info.length; i++) {
            if(info[i][1].compareTo(start) >= 0 && info[i][1].compareTo(end) <= 0) {
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] = info[i][0];
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Main2_6 T = new Main2_6();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
        System.out.println();
        T.refactor(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45");
        T.refactor(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59");
        T.refactor(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20");
    }
}
