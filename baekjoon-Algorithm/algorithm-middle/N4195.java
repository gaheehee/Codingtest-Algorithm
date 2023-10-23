import java.util.*;
import java.io.*;

public class N4195 {
    static HashMap<String, Integer> name_nums;
    static List<Integer> parent, nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int t = 0; t < test_case; t++) {
            int f = Integer.parseInt(br.readLine());
            name_nums = new HashMap<>();
            parent = new ArrayList<>();
            nums = new ArrayList<>();

            for (int i = 0; i < f; i++) {
                st = new StringTokenizer(br.readLine());
                String hh1 = st.nextToken();
                String hh2 = st.nextToken();

                if (!name_nums.containsKey(hh1)) {
                    name_nums.put(hh1, name_nums.size());
                    parent.add(name_nums.get(hh1));
                    nums.add(1);
                }

                if (!name_nums.containsKey(hh2)) {
                    name_nums.put(hh2, name_nums.size());
                    parent.add(name_nums.get(hh2));
                    nums.add(1);
                }

                int num = union(name_nums.get(hh1), name_nums.get(hh2));

                System.out.println(num);
            }
        }
    }

    public static int union (int h1, int h2) {
        h1 = find(h1);
        h2 = find(h2);

        if (h1 != h2) {
            if (h1 <= h2) {
                parent.set(h2, h1);
                nums.set(h1, nums.get(h1) + nums.get(h2));
                return nums.get(h1);
            } else {
                parent.set(h1, h2);
                nums.set(h2, nums.get(h2) + nums.get(h1));
                return nums.get(h2);
            }
        }
        return nums.get(h1);
    }

    public static int find(int x) {
        if (parent.get(x) == x)
            return x;

        /*parent.set(x, find(parent.get(x)));
        return parent.get(x);*/
        return find(parent.get(x));
    }
}
