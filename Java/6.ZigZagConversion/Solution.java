public class Solution {

    public String convert(String s, int numRows) {
        
        if (s == null || s.length() == 0) return s;

        StringBuilder[] lines = new StringBuilder[numRows];
        // for (StringBuilder line: lines) {
        //     line = new StringBuilder();
        // }

        for (int i = 0; i < lines.length; i++) lines[i] = new StringBuilder();

        int i = 0;
        int len = s.length();
        
        while (i < len) {
            int line = 0;
            while (i < len && line < numRows) {
                lines[line].append(s.charAt(i));
                line++;
                i++;
            }
            line = numRows - 2;
            while (i < len && line > 0) {
                lines[line].append(s.charAt(i));
                line--;
                i++;
            }

        }

        // Finally convert lines back to one string by row.
        StringBuilder finalSb = new StringBuilder();
        for (StringBuilder sb: lines) {
            finalSb.append(sb);
        }
        return finalSb.toString();
    }

}



