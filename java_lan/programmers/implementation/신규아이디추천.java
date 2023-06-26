import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        String tmp = "";

        new_id = new_id.toLowerCase();
        for(int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if(('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || c == '-' || c == '_' || c == '.') {
                tmp += c;
            }
        }
        new_id = "";
        boolean flag = false;
        for(int i = 0; i < tmp.length(); i++) {
            char c = tmp.charAt(i);
            if(flag && c == '.') {
                continue;
            }
            if(c == '.') {
                flag = true;
            } else {
                flag = false;
            }
            new_id += c;
        }
        if(new_id.length() > 0 && new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        }
        if(new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        if(new_id.length() == 0) {
            new_id = "a";
        }
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        while(new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        if(new_id.length() <= 2) {
            char c = new_id.charAt(new_id.length() - 1);
            while(new_id.length() <= 2) {
                new_id += c;
            }
        }
        answer = new_id;

        return answer;
    }
}