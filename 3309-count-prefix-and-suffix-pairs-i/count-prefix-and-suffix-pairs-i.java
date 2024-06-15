class Solution {
    public int countPrefixSuffixPairs(String[] words) {
     
        int count = 0;
        for(int i=0;i<words.length-1;i++){
            boolean flag = true;
            for(int j=i+1;j<words.length;j++){
                
                String s1 = words[i];
                String s2 = words[j];
                
                int l1 = s1.length();
                int l2 = s2.length();
                
                //System.out.println(s1+" / " + s2);
                //System.out.println(l1+" / " + l2);
                
                if(l1>l2){
                    continue;
                }
                
               
                
                int k1=0;
                while(k1<l1){
                    if(s1.charAt(k1)!=s2.charAt(k1)){
                        flag = false;
                        break;
                    }
                    k1++;
                }
                
                k1 = l1-1;
                int k2 = l2-1;
                while(k1>=0 && k2>=0 && flag==true){
                    if(s1.charAt(k1)!=s2.charAt(k2)){
                        flag = false;
                        break;
                    }
                    k1--;
                    k2--;
                }
                
                if(flag){
                    count++;
                }else{
                    flag = true;
                }
            }
        }
        return count;
    }
}