import java.util.*;

class Solution {
    int answer;
    char[] arr;
    int move;
    
    public void findMove(int i, int index) {
        move = Math.min(move, i * 2 + (arr.length - index));
        move = Math.min(move, i + (arr.length - index ) * 2);
    }
    
    public void makeA(char c) {
        if(c - 'A' <= 13) {
            answer += c - 'A';
        } else {
            answer += 'Z' - c + 1;
        }
    }
    
    public int solution(String name) {
        answer = 0;
        arr = name.toCharArray();
        move = arr.length - 1;
        
        for(int i = 0; i < arr.length; i++) {
            makeA(arr[i]);
            int index = i + 1;
            while(index < arr.length && arr[index] == 'A') {
                index++;
            }
            findMove(i, index);
        }
        answer += move;
        
        return answer;
    }
}