
class Solution {

     public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length());
            res.append('#');
            res.append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            int delimiterIndex = str.indexOf('#', i);

            int length = Integer.parseInt(
                str.substring(i, delimiterIndex)
            );

            int stringStart = delimiterIndex + 1;
            int stringEnd = stringStart + length;

            decoded.add(str.substring(stringStart, stringEnd));

            i = stringEnd;
        }

        return decoded;
    }
}