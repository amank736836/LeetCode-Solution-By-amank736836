class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;
        for(String log : logs){
            if(log.equals("../")){
                if(depth > 0){
                    depth -= 1;
                }
            }
            else if(log.equals("./")){
                continue;
            }
            else{
                depth += 1;
            }
        }
        return depth;
        
    }
}