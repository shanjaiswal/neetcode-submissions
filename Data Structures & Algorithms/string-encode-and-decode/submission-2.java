class Solution {
    public String encode(List<String> strs) {
        String s = "";
        for (String str : strs) {
            s = s + str.length() + "#" + str; 
        }
        return s;
    } // 4#neet4#code4#love3#you

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i<str.length();) {
            String len = "";
            while(str.charAt(i) != '#') {
                len += str.charAt(i);
                i++;
            }
            int strLen = Integer.parseInt(len);
            String s = str.substring(i+1, i+1+strLen);
            result.add(s);
            i = i+1+strLen;
        }
        return result;
    }
}
