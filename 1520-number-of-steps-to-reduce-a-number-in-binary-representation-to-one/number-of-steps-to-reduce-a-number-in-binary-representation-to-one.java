class Solution {
    public int numSteps(String s) {
        int cnt = 0;
        int carry = 0;

        for(int i=s.length()-1;i>=1;i--){
            int num = s.charAt(i) - '0';
            if(num == carry){
                cnt++;
            }else{
                cnt += 2;
                carry = 1;
            }
        }
        if(carry == 1){
            cnt++;
        }
        return cnt;
    }
}