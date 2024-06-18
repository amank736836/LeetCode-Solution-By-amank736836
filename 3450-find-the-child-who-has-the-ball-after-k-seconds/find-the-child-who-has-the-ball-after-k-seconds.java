class Solution {
    public int numberOfChild(int n, int k) {
        int position = 0;
        int direction = 1;
        for(int i=0;i<k;i++){
            position += direction;
            if(position == 0 || position == n-1){
                direction *= -1;
            }
        }

        return position;
    }
}