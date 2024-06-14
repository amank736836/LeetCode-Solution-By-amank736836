class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long concat = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mul = getMul(nums[j]);
            concat += (nums[i] * mul) + nums[j];
            i++;
            j--;
        }
        if (i == j) {
            concat += nums[i];
        }
        return concat;
    }

    public int getMul(int num) {
        int mul = 10;

        while (num > 9) {
            num = num / 10;
            mul *= 10;
        }

        return mul;
    }
}