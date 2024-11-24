public class SubstringsOfSizeThreeWithDistinctCharacters {
  public static void main(String[] args) {
    String s = "aababcabc";
    int ans = countGoodSubstrings(s);
    System.out.println(ans);
  }

  public static int countGoodSubstrings(String s) {
    int count = 0;

    for (int i = 0; i <= s.length() - 3; i++) {
      String substring = s.substring(i, i + 3);
      if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2) && s.charAt(i + 1) != s.charAt(i + 2)) {
        count++;
      }
    }

    return count;
  }
}
