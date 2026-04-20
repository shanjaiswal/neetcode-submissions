class Solution {

    public String encode(List<String> strs) {
        String s = "";
        for (String str : strs) {
            int length = str.length();
            s = s + length + "#" + str;
        }
        return s;
    }
    // 4#neet14#code........
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i<str.length();) {
            String length = "";
            while (str.charAt(i) != '#') {
                length = length + str.charAt(i);
                i++;
            }
            i++;
            int len = Integer.parseInt(length);
            String s = str.substring(i, i+len);
            result.add(s);
            i = i+len;
        }
        return result;
    }
}
