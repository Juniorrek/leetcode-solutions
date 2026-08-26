class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> charsCount = new HashMap<Character, Integer>();
        //1- iterate the String
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            //2- count characters
            if (charsCount.containsKey(c)) {
                int count = charsCount.get(c);
                charsCount.put(c, ++count);
            } else {
                charsCount.put(c, 1);
            }
        }

        //3- decide the first unique character and return
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer count = charsCount.get(c);
            if (count == 1) return i;
        }

        return -1;
    }
}

// Time complexity: O(n) - two linear passes over the string (building the
// count map, then scanning again to find the first count == 1).
// Space complexity: O(1) - the HashMap holds at most 26 entries since s
// consists only of lowercase English letters.
