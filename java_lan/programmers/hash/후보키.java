import java.util.*;

class Solution {
    
    int answer;
    Set<List<Integer>> indexSet;
    
    public boolean collect(String[][] relation, List<Integer> list) {
        for(List<Integer> indexList: indexSet) {
            int cnt = 0;
            for(int index: indexList) {
                if(list.contains(index)) cnt++;
            }
            if(cnt == indexList.size()) return false;
        }
        Set<String> set = new HashSet<>();
        for(int i = 0; i < relation.length; i++) {
            String str = "";
            for(int j: list) {
                str += relation[i][j];
            }
            set.add(str);
        }
        if(set.size() != relation.length) return false;
        indexSet.add(new ArrayList<>(list));
        
        return true;
    }
    
    public void combination(int n, int level, int index, String[][] relation, List<Integer> list) {
        if(n == level) {
            if(collect(relation, list)) {
                answer++;
            }
            return;
        }
        for(int i = index; i < relation[0].length; i++) {
            list.add(i);
            combination(n, level + 1, i + 1, relation, list);
            list.remove(Integer.valueOf(i));
        }
    }
    
    public int solution(String[][] relation) {
        answer = 0;
        indexSet = new HashSet<>();
        
        for(int i = 1; i <= relation[0].length; i++) {
            combination(i, 0, 0, relation, new ArrayList<>());
        }
        
        return answer;
    }
}