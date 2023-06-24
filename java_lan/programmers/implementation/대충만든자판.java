class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for(int i = 0; i < targets.length; i++) {
            int sum = 0;
            for(int j = 0; j < targets[i].length(); j++) {
                String c = String.valueOf(targets[i].charAt(j));
                int index = Integer.MAX_VALUE;
                for(int k = 0; k < keymap.length; k++) {
                    if(keymap[k].contains(c)) {
                        index = Math.min(index, keymap[k].indexOf(c) + 1);
                    }
                }
                if(index == Integer.MAX_VALUE) {
                    sum = -1;
                    break;
                }
                sum += index;
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}