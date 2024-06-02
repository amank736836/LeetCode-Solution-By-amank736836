class Solution {

    public int largestRectangleArea(int[] arr) {    
        
    
        int[] rb = new int[arr.length];
        rb = right_bound(arr);
        int[] lb = new int[arr.length];
        lb = left_bound(arr);

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int x = lb[i] + rb[i] - 1;
            if (arr[i] * x > max) {
                max = arr[i] * x;
            }
        }
        return max;
    }

    private static int[] left_bound(int[] arr) {
        int[] lb = new int[arr.length];
        Stack<Integer> st = new Stack<>();


        for (int i = 0; i < arr.length; i++) {
            lb[i] = 1;
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                lb[i] += lb[st.peek()];
                st.pop();
            }

            st.push(i);
            System.out.println(lb[i]);
        }

        return lb;
    }
    private static int[] right_bound(int[] arr) {
        int[] rb = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            rb[i] = 1;
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                rb[i] += rb[st.peek()];
                st.pop();
            }

            st.push(i);
            System.out.println(rb[i]);
        }
        return rb;
    } 
}