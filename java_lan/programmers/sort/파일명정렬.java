import java.util.*;
import java.util.stream.*;

class Solution {
    
    static class File implements Comparable<File> {
        
        String head, name;
        int number, index;
        
        public File(String head, int number, int index, String name) {
            this.head = head;
            this.number = number;
            this.index = index;
            this.name = name;
        }
        
        @Override
        public int compareTo(File o) {
            if(this.head.compareTo(o.head) != 0) {
                return this.head.compareTo(o.head);
            } else {
                return (this.number == o.number) ? (this.index - o.index) : (this.number - o.number);
            }
        }
    }
    
    public String[] solution(String[] files) {
        String[] answer = {};
        List<File> list = new ArrayList<>();
        
        for(int i = 0; i < files.length; i++) {
            String str = files[i];
            String head = "", number = "";
            int j = 0;
            for(; j < str.length(); j++) {
                if(!Character.isDigit(str.charAt(j))) {
                    head += str.charAt(j);
                } else {
                    break;
                }
            }
            for(; j < str.length(); j++) {
                if(Character.isDigit(str.charAt(j))) {
                    number += str.charAt(j);
                } else {
                    break;
                }
            }
            list.add(new File(head.toUpperCase(), Integer.parseInt(number), i, str));
        }
        Collections.sort(list);
        List<String> names = list.stream().map(l -> l.name).collect(Collectors.toList());
        answer = names.toArray(String[]::new);
        
        return answer;
    }
}