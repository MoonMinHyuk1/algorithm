package section2.primenum5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public int solution(int n) {
        int answer = 0;
        boolean[] check = new boolean[n];

        Arrays.fill(check, true);
        for(int i = 2; i <= n; i++) {
            if(check[i - 1] == true) {
                answer++;
                for(int j = i; j <= n; j = j + i) {
                    check[j - 1] = false;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(A.solution(n));
    }

}

/*
public class Main {

    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> prime = new ArrayList<>();

        for(int i = 2; i <= n; i++) {
            if(prime.size() == 0) {
                prime.add(i);
                answer++;
                continue;
            }
            boolean check = true;
            for(int j = 0; j < prime.size(); j++) {
                if(i % prime.get(j) == 0) {
                    check = false;
                    break;
                }
            }
            if(check == true) {
                prime.add(i);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(A.solution(n));
    }

}
*/


/*
import java.util.*;
class Main {
    public int solution(int n){
        int cnt=0;
        int[] ch = new int[n+1];
        for(int i=2; i<=n; i++){
            if(ch[i]==0){
                cnt++;
                for(int j=i; j<=n; j=j+i) ch[j]=1;
            }
        }
        return cnt;
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        System.out.println(T.solution(n));
    }
}*/