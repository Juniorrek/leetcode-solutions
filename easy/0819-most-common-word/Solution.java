class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> countWords = new HashMap<>();

        //1- Preparing the string
        // TODO: replace the chained replaceAll calls with a single regex split,
        // e.g. paragraph.toLowerCase().split("[^a-z]+"), to handle all punctuation
        // symbols (not just comma and period) in one pass.
        String[] words = paragraph.replaceAll(",", "").replaceAll("\\.", "").toLowerCase().split(" ");

        // TODO: load bannedWords into a HashSet<String> once, so the banned check
        // below becomes an O(1) lookup instead of an O(b) scan per word.
        //2- Iterate the list of words
        for (String word : words) {
            boolean isBanned = false;
            for (String bannedWord : banned) {
                //3- Ignoring the banned ones
                if (word.equals(bannedWord)) isBanned = true;
            }
            if (isBanned) continue;

            //4- Count words
            Integer counting = countWords.getOrDefault(word, 0);
            countWords.put(word, ++counting);
        }

        // TODO: track the max key while counting in the loop above instead of
        // doing a second pass over the map here.
        //5- Return the most common one
        Integer max = 0;
        String maxKey = "";
        for (String key : countWords.keySet()) {
            if (countWords.get(key) > max) {
                maxKey = key;
                max = countWords.get(key);
            }
        }

        return maxKey;
    }
}

// Time complexity: O(n * b + w) where n is the number of words in the
// paragraph, b is the number of banned words (checked per word), and w is
// the number of distinct words (final scan to find the max).
// Space complexity: O(w) for the HashMap holding one entry per distinct
// non-banned word (plus O(n) for the split words array).
