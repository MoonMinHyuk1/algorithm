package hash_parsing;

import java.util.*;

public class Main2_5 {

    public void test() {
        Map<String, Set<String>> hash = new HashMap<>();

        //putIfAbsent : key 가 map 에 존재하지 않을 때 put 을 해준다.
        //map value 에 자료구조를 사용할 때 사용
        hash.putIfAbsent("test", new HashSet<>());

        String a = "a";
        String b = "B";

        //앞이 작으면 음수, 대문자는 소문자 보다 작음
        System.out.println(a.compareTo(b)); //31
        //대소문자 상관없이 진행
        System.out.println(a.compareToIgnoreCase(b)); //-1

        System.out.println("---------------------");
    }

    public String solution(String[] votes, int k){
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> gift = new HashMap<>();
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        for(String str : votes) {
            String[] vote = str.split(" ");
            map.put(vote[1], map.getOrDefault(vote[1], 0) + 1);
            if(map.get(vote[1]) >= k) {
                set.add(vote[1]);
            }
        }
        int max = 0;
        for(String str : votes) {
            String[] vote = str.split(" ");
            if(set.contains(vote[1])) {
                gift.put(vote[0], gift.getOrDefault(vote[0], 0) + 1);
                max = Math.max(max, gift.get(vote[0]));
            }
        }
        for(String key : gift.keySet()) {
            if(gift.get(key) == max) {
                list.add(key);
            }
        }
//        Collections.sort(list);
//        list.sort((a, b) -> a.compareTo(b));
//        Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        answer = list.get(0);

        return answer;
    }

    public static void main(String[] args){
        Main2_5 T = new Main2_5();
        T.test();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
