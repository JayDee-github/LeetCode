class Solution {
    public int lengthOfLongestSubstring(String s) {
      int max = 0;
      int current = 0;
      HashMap<Character, Integer> charMap = new HashMap();

      int lastDouble = 0;

      for (int i=0; i<s.length(); i++) {
        char currentChar = s.charAt(i);

        if (charMap.containsKey(currentChar)) {
          if (current > max)
            max = current;

          if (charMap.get(currentChar) < lastDouble)
            current = i - lastDouble;
          else {
            current = i - charMap.get(currentChar);
            lastDouble = charMap.get(currentChar);
          }
        } else
          current++;

        charMap.put(currentChar, i);
      }

      if (current > max)
        max = current;

      return max;
    }
}
