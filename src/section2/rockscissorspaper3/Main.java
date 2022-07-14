package section2.rockscissorspaper3;

import java.util.Scanner;

public class Main {

    public char[] solution(int[] arrA, int[] arrB) {
        char[] answer = new char[arrA.length];

        for(int i = 0; i < answer.length; i++) {
            if(arrA[i] == arrB[i]) {
                answer[i] = 'D';

            }
            else if((arrA[i] > arrB[i]) && !(arrA[i] == 3 && arrB[i] == 1)) {
                answer[i] = 'A';
            }
            else if(arrA[i] == 1 && arrB[i] == 3) {
                answer[i] = 'A';
            }
            else {
                answer[i] = 'B';
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main A = new Main();
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int[] arrA = new int[len];
        int[] arrB = new int[len];
        for(int i = 0; i < len; i++) {
            arrA[i] = sc.nextInt();
        }
        for(int i = 0; i < len; i++) {
            arrB[i] = sc.nextInt();
        }
        for(char x : A.solution(arrA, arrB)) {
            System.out.println(x);
        }
    }

}



//import java.util.*;
//class Main {
//    public String solution(int n, int[] a, int[] b){
//        String answer="";
//        for(int i=0; i<n; i++){
//            if(a[i]==b[i]) answer+="D";
//            else if(a[i]==1 && b[i]==3) answer+="A";
//            else if(a[i]==2 && b[i]==1) answer+="A";
//            else if(a[i]==3 && b[i]==2) answer+="A";
//            else answer+="B";
//        }
//        return answer;
//    }
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        int n=kb.nextInt();
//        int[] a=new int[n];
//        int[] b=new int[n];
//        for(int i=0; i<n; i++){
//            a[i]=kb.nextInt();
//        }
//        for(int i=0; i<n; i++){
//            b[i]=kb.nextInt();
//        }
//        for(char x : T.solution(n, a, b).toCharArray()) System.out.println(x);
//    }
//}