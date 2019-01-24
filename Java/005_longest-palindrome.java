class Solution {
  class StringIndices {
    public int start;
    public int end;
    public int length;

    public StringIndices(int s, int e) {
      this.start = s;
      this.end = e;
      this.length = end - start;
    }
  }

  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0)
      return "";

    StringIndices maxPali = new StringIndices(0, 0);

    for (int i=0; i<s.length(); i++) {
      StringIndices oddIndices = getPali(s, i, i);
      StringIndices evenIndices = getPali(s, i, i + 1);

      StringIndices strMax;

      if ((oddIndices == null) && (evenIndices == null))
        continue;
      else if (evenIndices == null)
        strMax = oddIndices;
      else if (oddIndices == null)
        strMax = evenIndices;
      else
        strMax = oddIndices.length > evenIndices.length ?
          oddIndices : evenIndices;

      if (strMax.length > maxPali.length)
        maxPali = strMax;
    }

    return s.substring(maxPali.start, maxPali.end);
  }

  public StringIndices getPali(String str, int l, int r) {
    if ((str == null) ||
        (str.length() == 0) ||
        (l < 0) ||
        (r >= str.length()))
      return null;

    int left = l;
    int right = r;

    while ((left >= 0) &&
           (right < str.length()) &&
           (str.charAt(left) == str.charAt(right))) {
      left--;
      right++;
    }

    return new StringIndices(left + 1, right);
  }
}