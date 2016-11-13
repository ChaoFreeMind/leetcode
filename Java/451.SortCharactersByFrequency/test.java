public class Solution {
 public String countAndSay(int n) {    
     if (n == 0) return "";
     if (n == 1) return "1";
     if (n == 2) return "11";
     String res = "11";

     for (int i = 3; i <= n; i++) {
         StringBuilder sb = new StringBuilder();
         // if (i == 1) sb.append(1);
         // if (i == 2) sb.append(11);
         int num = 1;
         for (int j = 0; j < res.length() - 1; j++) {
             
             if (res.charAt(j) == res.charAt(j + 1)) {
                 num++;
                 if(j + 1 == res.length() - 1) {
                     sb.append(num);
                     sb.append(res.charAt(j));
                 }
             }
             else {
                 sb.append(num);
                 sb.append(res.charAt(j));
                 num = 1;
                 if(j + 1 == res.length() - 1) {
                     sb.append(1);
                     sb.append(res.charAt(j + 1));
                 }
             }
         }
         res = sb.toString();

     }
     return res;
 }

 public static void main(String[] args) {
     int n = 9;
     Solution s = new Solution();
     System.out.println(s.countAndSay(n));
 }
}