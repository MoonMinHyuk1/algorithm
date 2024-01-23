import java.util.*;

class Solution {
    
    public int toInteger(String str) {
        String[] arr = str.split(":");
        return Integer.parseInt(arr[0]) * 3600 + Integer.parseInt(arr[1]) * 60 + Integer.parseInt(arr[2]);
    }
    
    public String toString(long time) {
        String str = "";
        long h = time / 3600;
        long m = (time % 3600) / 60;
        long s = (time % 3600) % 60;
        str += (h < 10) ? ("0" + h + ":") : (h + ":");
        str += (m < 10) ? ("0" + m + ":") : (m + ":");
        str += (s < 10) ? ("0" + s) : s;
        return str;
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int pt = toInteger(play_time), at = toInteger(adv_time);
        int[] sum = new int[pt + 1];
        
        for(String str: logs) {
            String[] log = str.split("-");
            int s = toInteger(log[0]), e = toInteger(log[1]);
            sum[s] += 1;
            sum[e] -= 1;
        }
        for(int i = 1; i < sum.length; i++) {
            sum[i] += sum[i - 1];
        }
        long now = 0, max = 0, maxt = 0;
        for(int i = 0; i < at - 1; i++) {
            now += sum[i];
        }
        for(int i = at - 1; i < sum.length; i++) {
            now += sum[i];
            if(now > max) {
                maxt = i - at + 1;
                max = now;
            }
            now -= sum[i - at + 1];
        }
        answer = toString(maxt);
        
        return answer;
    }
}