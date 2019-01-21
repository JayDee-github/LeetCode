class Solution {
    public String longestPalindrome(String s) {
      if (s == null || s.length() == 0)
        return "";
      
      String maxPali = "";
      int maxLength = 0;
      
      for (int i=0; i<s.length(); i++) {
        String strOdd = getPali(s, i, i);
        String strEven = getPali(s, i, i + 1);
       
        String strMax = strOdd.length() > strEven.length() ?
          strOdd : strEven;
        
        if (strMax.length() > maxLength) {
          maxPali = strMax;
          maxLength = strMax.length();
        }
      }
      
      return maxPali;
    }
  
    public String getPali(String str, int l, int r) {
      if ((str == null) ||
          (str.length() == 0) ||
          (l < 0) ||
          (r >= str.length()))
        return "";
      
      int left = l;
      int right = r;
      
      while ((left >= 0) &&
             (right < str.length()) &&
             (str.charAt(left) == str.charAt(right))) {
        left--;
        right++;
      }
      
      return str.substring(left + 1, right);
    }
}
