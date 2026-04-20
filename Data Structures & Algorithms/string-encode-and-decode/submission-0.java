class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        String del = "#";
        for (String s : strs) {
            int len = s.length();
            sb.append(len);
            sb.append(del);
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i<str.length(); ) {
            int end = i+1;
            while(end<str.length() && str.charAt(end) != '#'){
                end++;
            }
            String length = str.substring(i, end);
            int len = Integer.parseInt(length);
            int startIndex = end+1;
            int lastIndex = end+1+len;
            res.add(str.substring(startIndex, lastIndex));
            i = lastIndex;
        }
        return res;
    }
}
