class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    static void mergeSort(int nums[],int low,int high){
        if(low < high){
            int mid = low + (high - low) / 2;
            mergeSort(nums,low,mid);
            mergeSort(nums,mid + 1,high);
            merge(nums,low,mid,high);
        }
    }
    static void merge(int nums[],int low,int mid,int high){
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        for(int i=0;i<n1;i++){
            leftArray[i] = nums[low + i];
        }
        for(int i=0;i<n2;i++){
            rightArray[i] = nums[mid+1+i];
        }

        int index = low;
        int i = 0;
        int j = 0;
        while(i < n1 && j < n2){
            if(leftArray[i] < rightArray[j]){
                nums[index] = leftArray[i];
                i++;
            }else{
                nums[index] = rightArray[j];
                j++;
            }
            index++;
        }
        while(i < n1){
            nums[index] = leftArray[i];
            i++;
            index++;
        }
        while(j < n2){
            nums[index] = rightArray[j];
            j++;
            index++;
        }
    }
}