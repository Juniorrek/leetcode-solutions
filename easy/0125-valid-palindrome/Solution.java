class Solution {
    public boolean isPalindrome(String s) {
        //1- converting from upper to lower
        String lower = s.toLowerCase();
        //2- removing all non-alphanumeric
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        String str = sb.toString();
        //3- reading it
        int j = str.length() - 1;
        boolean palindrome = true;
        for(int i = 0; i < str.length(); i++) {
            if (i >= j) break;

            if (str.charAt(i) != str.charAt(j)) {
                palindrome = false;
                break;
            }

            j--;
        }

        return palindrome;
    }
}