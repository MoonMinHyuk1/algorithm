import java.util.*;

class Solution {
    // 배열
    // public boolean solution(String[] phone_book) {
    //     boolean answer = true;
    //     int n = phone_book.length;
        
    //     Arrays.sort(phone_book);
    //     for(int i = 0; i < n - 1; i++) {
    //         if(phone_book[i + 1].startsWith(phone_book[i])) {
    //             return false;
    //         }
    //     }
        
    //     return answer;
    // }

    // 해시
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();
        
        for(String str : phone_book) {
            set.add(str);
        }
        for(String key : set) {
            for(int i = 1; i < key.length(); i++) {
                if(set.contains(key.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return answer;
    }
}