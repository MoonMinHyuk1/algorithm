import java.util.*;
import java.io.*;

public class Main9498 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    int score = Integer.parseInt(str);
    char grade = 'A';

    if(score >= 90) {
      grade = 'A';
    } else if(score >= 80) {
      grade = 'B';
    } else if(score >= 70) {
      grade = 'C';
    } else if(score >= 60) {
      grade = 'D';
    } else {
      grade = 'F';
    }

    System.out.println(grade);
  }
}