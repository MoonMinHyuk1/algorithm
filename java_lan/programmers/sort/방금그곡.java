import java.util.*;

class Solution {
    
    static class Music {
        String name;
        String melody;
        int length, index;
        
        public Music(String name, String melody, int length, int index) {
            this.name = name;
            this.melody = melody;
            this.length = length;
            this.index = index;
        }
    }
    
    public int getLength(String start, String end) {
        int s = Integer.parseInt(start.split(":")[0]) * 60 + Integer.parseInt(start.split(":")[1]);
        int e = Integer.parseInt(end.split(":")[0]) * 60 + Integer.parseInt(end.split(":")[1]);
        return e - s;
    }
    
    public String getOriginal(String original) {
        original = original.replace("C#", "c");
        original = original.replace("D#", "d");
        original = original.replace("F#", "f");
        original = original.replace("G#", "g");
        original = original.replace("A#", "a");
        return original;
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        List<Music> list = new ArrayList<>();
        
        m = getOriginal(m);
        for(int i = 0; i < musicinfos.length; i++) {
            int length = getLength(musicinfos[i].split(",")[0], musicinfos[i].split(",")[1]);
            String name = musicinfos[i].split(",")[2];
            String original = getOriginal(musicinfos[i].split(",")[3]);
            String melody = "";
            for(int j = 0; j < length; j++) {
                melody += original.charAt(j % original.length());
            }
            list.add(new Music(name, melody, length, i));
        }
        Collections.sort(list, (o1, o2) -> ((o1.length == o2.length) ? (o1.index - o2.index) : (o2.length - o1.length)));
        
        for(Music music: list) {
            if(music.melody.contains(m)) {
                return music.name;
            }
        }
        
        return answer;
    }
}