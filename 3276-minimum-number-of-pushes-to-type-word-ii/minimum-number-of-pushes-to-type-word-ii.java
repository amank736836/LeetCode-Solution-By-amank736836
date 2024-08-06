class Solution {
    public int minimumPushes(String word) {
        int letterFrequency[] = new int[26];
        for (char c : word.toCharArray()) {
            letterFrequency[c - 'a']++;
        }

        Arrays.sort(letterFrequency);

        for (int i = 0; i < 26 / 2; i++) {
            int temp = letterFrequency[i];
            letterFrequency[i] = letterFrequency[25 - i];
            letterFrequency[25 - i] = temp;
        }

        int totalPresses = 0;
        for (int i = 0; i < 26; i++) {
            if (letterFrequency[i] == 0) {
                break;
            }
            totalPresses += (i / 8 + 1) * letterFrequency[i];
        }
        return totalPresses;

    }
}