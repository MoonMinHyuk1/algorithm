import java.util.*;
import java.io.*;

public class Main1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character c : str.toCharArray()) {
            if(c >= 'a' && c <= 'z') {
                c = Character.toUpperCase(c);
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int max = 0, maxCheck = 0;
        Character maxCharacter = 'A';
        for(Character c : map.keySet()) {
            if(map.get(c) > max) {
                max = map.get(c);
                maxCheck = 1;
                maxCharacter = c;
            } else if(map.get(c) == max) {
                maxCheck++;
            }
        }
        if(maxCheck > 1) {
            sb.append("?");
        } else {
            sb.append(maxCharacter);
        }

        System.out.print(sb);
    }
}