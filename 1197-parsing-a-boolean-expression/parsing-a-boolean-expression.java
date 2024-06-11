class Solution {

    private int i = 0;

    public boolean parseBoolExpr(String expression) {
        this.i = 0;
        if(expression.length() == 1){
            return expression.charAt(0) == 't';
        }
        return recursion(expression);
    }

    public boolean recursion(String exp){
        char operator = exp.charAt(this.i);
        this.i += 2;
        char c = exp.charAt(this.i);

        boolean result = false;
        if(c == 't'){
            result = true;
            this.i++;
        }
        else if(c=='f'){
            result = false;
            this.i++;
        }else{
            result = recursion(exp);
        }

        c = exp.charAt(this.i);
        while(c!=')'){

            if(c==','){
                c = exp.charAt(this.i+1);
                this.i++;
                continue;
            }

            boolean curr;
            if(c == 't'){
                curr = true;
                this.i++;
            }
            else if(c=='f'){
                curr = false;
                this.i++;
            }else{
                curr = recursion(exp);
            }
        
            if(operator == '&'){
                result = result & curr;
            }
            else if(operator == '|'){
                result = result | curr;
            }

            c = exp.charAt(this.i);
        }
        this.i++;

        return operator == '!' ? !result : result;

    }
}