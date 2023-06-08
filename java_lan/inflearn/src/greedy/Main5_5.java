package greedy;

import java.util.*;

public class Main5_5 {

    static class Student implements Comparable<Student> {
        int index;
        char team;
        int attack;

        public Student(int index, char team, int attack) {
            this.index = index;
            this.team = team;
            this.attack = attack;
        }

        @Override
        public int compareTo(Student o) {
            return this.attack - o.attack;
        }
    }

    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];
        List<Student> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < students.length; i++) {
            list.add(new Student(i, students[i].split(" ")[0].charAt(0), Integer.parseInt(students[i].split(" ")[1])));
        }
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            int score = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(student.attack == list.get(j).attack) {
                    continue;
                }
                if(student.team == list.get(j).team) {
                    score += map.getOrDefault(student.team, 0);
                    for(int k = j - 1; k >= 0; k--) {
                        if(list.get(j).attack == list.get(k).attack) {
                            if(list.get(j).team != list.get(k).team) {
                                score += list.get(k).attack;
                            }
                        } else {
                            break;
                        }
                    }
                    break;
                } else {
                    score += list.get(j).attack;
                }
            }
            map.put(student.team, score);
            answer[student.index] = score;
        }

        return answer;
    }

    public static void main(String[] args){
        Main5_5 T = new Main5_5();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}
