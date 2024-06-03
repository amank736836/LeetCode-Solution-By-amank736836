class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,Integer> hm = new HashMap<>();
        boolean check = true;
        for(String val : wordList){
            if(!hm.containsKey(val)){
                hm.put(val,0);
            }
            if(check && val.equals(endWord)){
                check = false;
            }
        }

        if(check){
            return 0;
        }

        int cnt = 1;
        ArrayDeque<String> q = new ArrayDeque<>();
        q.add(beginWord);
        hm.remove(beginWord);
        while(!q.isEmpty()){
            int size = q.size();
            for(int k=0;k<size;k++){
                String st = q.remove();
                if(st.equals(endWord)){
                    return cnt;
                }
                char replaceWord[] = st.toCharArray();
                for(int i=0;i<st.length();i++){
                    for(char j='a';j<='z';j++){
                        char x = replaceWord[i];
                        replaceWord[i] = j;
                        String newst = new String(replaceWord);
                        if(hm.containsKey(newst)){
                            // System.out.println(newst);
                            q.add(newst);
                            hm.remove(newst);
                        }
                        replaceWord[i] = x;


                    }
                }
            }
            cnt++;

        }
        return 0;
    }
}