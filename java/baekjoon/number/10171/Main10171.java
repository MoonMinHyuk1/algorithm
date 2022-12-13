import java.util.*;
import java.io.*;

public class Main10171 {
  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    bw.write("\\    /\\\n");
    bw.write(" )  ( ')\n");
    bw.write("(  /  )\n");
    bw.write(" \\(__)|");

    bw.flush();
    bw.close();
  }
}