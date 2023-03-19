import java.util.*;

class Main1874 {
  public void solution(int n, int[] arr) {
    ArrayList<String> answer = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    int index = 0;

    for(int i = 1; i <= n; i++) {
      stack.push(i);
      answer.add("+");
      while(index < n && !stack.isEmpty() && arr[index] == stack.peek()) {
        stack.pop();
        answer.add("-");
        index++;
      }
    }

    if(stack.isEmpty()) {
      for(String s : answer) {
        System.out.println(s);
      }
    } else {
      System.out.println("NO");
    }
  }

  public static void main(String[] args) {
    Main1874 A = new Main1874();
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    A.solution(n, arr);
  }
}