class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        boolean anagram = true;
        //1 - Iterate string 1
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            //2 - Foreach character find equal in string 2 and remove
            boolean found = false;
             for (int j = 0; j < t.length(); j++) {
                char c2 = t.charAt(j);
                //3 - If equal remove and continue
                if (c1 == c2) {
                    t = t.replaceFirst(String.valueOf(c1), "");
                    found = true;
                    break;
                }
            }
            //4- Didn't find an equal character, not an anagram
            if (!found) {
                anagram = false;
                break;
            }
        }
        return anagram;
    }
}