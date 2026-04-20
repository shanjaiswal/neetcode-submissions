class Solution {

    public String encode(List<String> strs) {
        String s = "";
        for (String str : strs) {
            s = s + str.length() + "#" + str;
        }
        return s;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            String len = "";
            while (str.charAt(i) != '#') {
                len = len + str.charAt(i);
                i++;
            }
            i++;
            int strLen = Integer.parseInt(len);
            result.add(str.substring(i, i+strLen));
            i = i+strLen;
        }
        return result;
    }
}
