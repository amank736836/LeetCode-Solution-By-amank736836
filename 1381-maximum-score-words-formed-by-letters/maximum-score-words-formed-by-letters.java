class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        if(words == null || words.length == 0 || 
            letters == null || letters.length == 0 ||
            score == null || score.length == 0 ){
                return 0;
        }

        int[] count = new int[score.length];
        for(char ch : letters){
            count[ch - 'a']++;
        }

        return backtrack(words,score,count,0);
    }

    public int backtrack(String[] words,int[] score,int[] count,int index){
        int maxi = 0;

        for(int i=index;i<words.length;i++){
            int res = 0;
            boolean isValid = true;
            for(char ch : words[i].toCharArray()){
                count[ch-'a']--;
                res += score[ch-'a'];
                if(count[ch-'a'] < 0){
                    isValid = false;
                }
            }

            if(isValid){
                res += backtrack(words,score,count,i+1);
                maxi = Math.max(maxi , res);
            }

            for(char ch : words[i].toCharArray()){
                count[ch-'a']++;
                res = 0;
            }
        }

        return maxi;
    }
}