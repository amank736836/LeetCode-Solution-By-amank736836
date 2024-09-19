class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for(int index = 0;index<expression.length();index++){
            char ch = expression.charAt(index);
            if(ch == '+' || ch == '-' || ch == '*'){
                String leftPart = expression.substring(0,index);
                String rightPart = expression.substring(index+1);
                List<Integer> leftList = diffWaysToCompute(leftPart);
                List<Integer> rightList = diffWaysToCompute(rightPart);
                for(int l : leftList){
                    for(int r : rightList){
                        if(ch == '+'){
                            res.add(l+r);
                        }else if(ch == '-'){
                            res.add(l-r);
                        }else{
                            res.add(l*r);
                        }
                    }
                }
            }
        }
        if(res.size() == 0){
            res.add(Integer.valueOf(expression));
        }
        return res;
    }
}