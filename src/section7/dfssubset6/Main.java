package section7.dfssubset6;

public class Main {
    static int n;
    static int[] ch;
    public void DFS(int L) {
        if(L == n + 1) {
            boolean check = true;
            for(int i = 1; i < ch.length; i++) {
                if(ch[i] == 1){
                    System.out.print(i + " ");
                    check = false;
                }
            }
            if(!check) {
                System.out.println();
            }
        } else {
            ch[L] = 1;
            DFS(L + 1); //왼쪽
            ch[L] = 0;
            DFS(L + 1); //오른쪽
        }
    }

    public static void main(String[] args) {
        Main A = new Main();
        n = 3;
        ch = new int[n + 1];
        A.DFS(1);
    }
}
