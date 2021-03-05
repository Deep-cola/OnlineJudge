package newcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description:
 * @author: Deepcola
 * @time: 2021/3/5 18:21
 */
public class GetLeastKCounts {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input.length == 0 || k > input.length) return result;
        Arrays.sort(input);
        for(int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }
}
