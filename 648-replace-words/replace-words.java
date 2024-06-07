class Solution {
    private Trie root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Trie();
        for(String word : dictionary){
            insert(word);
        }

        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        for(int i=0;i<words.length;i++){
            if(i>0){
                result.append(" ");
            }
            result.append(search(words[i]));
        }
        return result.toString();

    }

    public String search(String word){
        Trie node = root;
        for(int j = 0;j<word.length();j++){
            char c = word.charAt(j);
            int index = c - 'a';
            if(node.children[index]== null){
                return word;
            }
            node = node.children[index];
            if(node.isEnd){
                return word.substring(0,j+1);
            }
        }
        return word;
    }

    public void insert(String word){
        Trie node = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    class Trie{
        private Trie[] children;
        private boolean isEnd;
        public Trie(){
            children = new Trie[26];
            isEnd = false;
        }
    }
}
