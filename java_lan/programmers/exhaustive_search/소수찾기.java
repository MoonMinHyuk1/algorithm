import java.util.*;

class Solution {
    int answer;
    char[] num;
    Set<Integer> set;
    boolean[] prime = new boolean[100000000];
    boolean[] visited;

    public void isPrime() {
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for(int i = 2; i < prime.length; i++) {
            if(prime[i]) {
                for(int j = 2 * i; j < prime.length; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    public void dfs(int level, int n) {
        if(level == num.length) {
            return;
        }
        for(int i = 0; i < num.length; i++) {
            if(!visited[i]) {
                int val = (n * 10) + (num[i] - '0');
                if(prime[val]) {
                    set.add(val);
                }
                visited[i] = true;
                dfs(level + 1, val);
                visited[i] = false;
            }
        }
    }

    public int solution(String numbers) {
        answer = 0;
        num = numbers.toCharArray();
        set = new HashSet<>();
        visited = new boolean[100000000];

        isPrime();
        dfs(0, 0);
        answer = set.size();

        return answer;
    }
}