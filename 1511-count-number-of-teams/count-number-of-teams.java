class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int left_smaller = 0;
            int right_greater = 0;
            int left_greater = 0;
            int right_smaller = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    left_smaller++;
                }
                if (rating[j] > rating[i]) {
                    left_greater++;
                }
            }
            for (int k = i + 1; k < n; k++) {
                if (rating[k] > rating[i]) {
                    right_greater++;
                }
                if (rating[k] < rating[i]) {
                    right_smaller++;
                }
            }

            count += left_smaller * right_greater;
            count += left_greater * right_smaller;
        }
        return count;
    }
}