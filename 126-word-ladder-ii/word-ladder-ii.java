class Solution {
    String b;
    HashMap<String,Integer> map;
    List<List<String>> ans;

    private void dfs(String end,List<String> seq){
        if(end.equals(b)){
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }

        int steps = map.get(end);
        int size = b.length();
        for(int i=0;i<size;i++){
            for(char ch = 'a';ch<='z';ch++){
                char newstrArray[] = end.toCharArray();
                newstrArray[i] = ch;
                String replaceWord = new String(newstrArray);
                if(map.containsKey(replaceWord) && map.get(replaceWord) + 1 == steps){
                    seq.add(replaceWord);
                    dfs(replaceWord,seq);
                    seq.remove(seq.size()-1);
                }
            }
        }
    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> hm = new HashSet<>(wordList);

        // for(String val : wordList){
        //     if(!hm.containsKey(val)){
        //         hm.put(val,0);
        //     }
        // }

        ans = new ArrayList<>();
        b = beginWord;

        if(!hm.contains(endWord)){
            return ans;
        }

        ArrayDeque<String> q = new ArrayDeque<>();
        map = new HashMap<>();

        q.add(beginWord);
        map.put(beginWord, 1);
        hm.remove(beginWord);
        
        int sizee = beginWord.length();

        while(!q.isEmpty()){

            String str = q.poll();
            int steps = map.get(str);

            if(str == endWord){
                break;
            }
            
            char newstrArray[] = str.toCharArray();
            for(int i=0;i<sizee;i++){
                for(char ch='a';ch<='z';ch++){
                    char x = newstrArray[i];
                    newstrArray[i] = ch;
                    String newstr = new String(newstrArray);
                    if(hm.contains(newstr)){
                        q.add(newstr);
                        map.put(newstr,steps+1);
                        hm.remove(newstr);
                    }
                    newstrArray[i] = x;
                }
            }  
        }

        if(map.containsKey(endWord)){
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord,seq);
        }

        return ans;
    }
}