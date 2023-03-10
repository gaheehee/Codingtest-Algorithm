import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num = Integer.parseInt(br.readLine());

        char alphabet = str.charAt(num-1);
        System.out.println(alphabet);
    }
}
