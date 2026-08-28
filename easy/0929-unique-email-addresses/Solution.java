class Solution {
    public int numUniqueEmails(String[] emails) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        //1- Parse the emails local name
        for (String email : emails) {
            String[] emailSplit = email.split("@");
            String domainName = emailSplit[1];
            String localName = emailSplit[0];
            localName = localName.replaceAll("\\.", "").split("\\+")[0];

            //2- Define the key and store then in a map
            String key = localName + "@" + domainName;
            Integer count = map.getOrDefault(key, 0);
            map.put(key, ++count);
        }

        //3- Return the map length
        return map.keySet().size();
    }
}
