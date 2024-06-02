
class Solution {

    public int maximalRectangle(char[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[] = new int[m];

        int sum =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == '0'){
                    dp[j] = 0;
                }else{
                    dp[j] += 1;
                }
            }
            sum = Math.max(sum , largest(dp));
        }

        return sum;

    }

    public int largest(int[] dp){
        int maxA = 0;
        int m = dp.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<=m;i++){
            while(!st.empty() && (i==m || dp[st.peek()] >= dp[i])){
                int height = dp[st.pop()];
                int width;
                if(st.empty()){
                    width = i;
                }
                else{
                    width = i - 1 - st.peek();
                }
                maxA = Math.max(maxA , width * height);
            }
            st.push(i);
        }
        return maxA;
    }

}