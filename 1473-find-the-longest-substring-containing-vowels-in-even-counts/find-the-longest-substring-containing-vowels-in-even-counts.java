class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Character,Integer> vowels = new HashMap<>();
        vowels.put('a',1);
        vowels.put('e',2);
        vowels.put('i',4);
        vowels.put('o',8);
        vowels.put('u',16);

        Map<Integer,Integer> firstOccurrence = new HashMap<>();
        firstOccurrence.put(0,-1);

        int mask = 0;
        int maxLength = 0;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(vowels.containsKey(c)){
                mask ^= vowels.get(c);
            }

            if(firstOccurrence.containsKey(mask)){
                maxLength = Math.max(maxLength,i-firstOccurrence.get(mask));
            }else{
                firstOccurrence.put(mask,i);
            }
        }

        return maxLength;
    }
}