package section2.primechange6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> prime = new ArrayList<>();
        boolean[] check = new boolean[100000];

        Arrays.fill(check, true);
        check[0] = false;
        for(int i = 2; i < 100000; i++) {
            if(check[i - 1] == true) {
                prime.add(i);
                for(int j = i; j < 100000; j = j + i) {
                    check[j - 1] = false;
                }
            }
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 2) continue;
            int n = 0;
            while(arr[i] != 0) {
                n *= 10;
                n += arr[i] % 10;
                arr[i] = arr[i] / 10;
            }
            if(prime.contains(n)) {
                answer.add(n);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x : A.solution(arr)) {
            System.out.print(x + " ");
        }
    }

}



/*import java.util.*;
class Main {
    public boolean isPrime(int num){
        if(num==1) return false;
        for(int i=2; i<num; i++){
            if(num%i==0) return false;
        }
        return true;
    }

    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<n; i++){
            int tmp=arr[i];
            int res=0;
            while(tmp>0){
                int t=tmp%10;
                res=res*10+t;
                tmp=tmp/10;
            }
            if(isPrime(res)) answer.add(res);
        }
        return answer;
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        for(int x : T.solution(n, arr)){
            System.out.print(x+" ");
        }
    }
}*/