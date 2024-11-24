import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
  public static void main(String[] args) {
    String s = "taa"; 
    String t = "aat";
    System.out.println(isAnagram(s, t));
  }

  private static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    // we first find the freq of the biggest String
    int[] map1 = new int[26];
    for (int i = 0; i < s.length(); i++) {
      map1[s.charAt(i) - 'a']++;
      map1[t.charAt(i) - 'a']--;
    }
    for (int num : nums) {
      if (num != 0) {
        return false;
      }
    }

    return true;
  }
}
