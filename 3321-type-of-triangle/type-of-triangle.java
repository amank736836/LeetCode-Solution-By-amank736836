class Solution {
    public String triangleType(int[] nums) {
        
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        if (isValidTriangle(a, b, c)) {
            if(a==b && b==c){
                return "equilateral";
            }else if(a==b || b==c || c==a){
                return "isosceles";
            }else return "scalene";
        }
        return "none";
        
    }
    private boolean isValidTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }
}