import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
public class dijkstra_vec {
    public static List<Integer> genPrimes(int amount) {
        ArrayList<int[]> arr = new ArrayList<>(amount);
        arr.add(new int[]{2, 4});
        int i = 3;
        while (arr.size() < amount) {
            boolean flag = true;
            for (int[] ii: arr) {
                int prime = ii[0], next = ii[1];
                if (next == i) {
                    ii[1] = next + prime;
                    flag = false;
                } else if (prime * prime == next) {
                    // if we reached the primes that have not appeared yet, and i is still smaller,
                    // no further prime can appear with a smaller next apperance
                    break;
                }
            }
            if (flag) {
                arr.add(new int[]{i, i * i});
            }
            i += 1;
        }
        ArrayList<Integer> ret = new ArrayList<>(amount);
        for (int[] ii: arr) {
            ret.add((Integer) ii[0]);
        }
        return ret;
    }
}
