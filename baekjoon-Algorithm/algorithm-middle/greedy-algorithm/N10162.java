import java.util.*;
import java.io.*;

public class N10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int modA = T / 300;
        int remainA = T % 300;

        int modB = remainA / 60;
        int remainB = remainA % 60;

        int modC = remainB / 10;
        int remainC = remainB % 10;

        if (remainC != 0) {
            System.out.println(-1);
        } else {
            System.out.println(modA + " " + modB + " " + modC);
        }
    }
}
