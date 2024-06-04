class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        var shift = 31 ^ Integer.numberOfLeadingZeros(left ^ right | 1);
        return left >>> shift << shift;
    }
}