import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : arr)
            map.put(n, map.getOrDefault(n, 0) + 1);

        int[] sortedFreq = new int[map.size()];
        int i = 0;

        for (int freq : map.values())
            sortedFreq[i++] = freq;

        Arrays.sort(sortedFreq);

        for (i = 0; i < sortedFreq.length; i++) {
            if (k < sortedFreq[i]) break;
            k -= sortedFreq[i];
        }
        return sortedFreq.length - i;
    }
}
