class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0){
            return false;
        }
        Arrays.sort(hand);
        int i;
        for(i=0;i<n;i++){
            if(hand[i] >= 0){
                if(!findsuccessors(hand,groupSize,i,n)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean findsuccessors(int[] hand,int groupSize,int i,int n){
        int f = hand[i] + 1;
        hand[i] = -1;
        int count = 1;
        i += 1;
        while(i<n && count < groupSize){
            if(hand[i] == f){
                f = hand[i] + 1;
                hand[i] = -1;
                count++;
            }
            i++;
        }
        if(count != groupSize){
            return false;
        }else{
            return true;
        }
    }
}