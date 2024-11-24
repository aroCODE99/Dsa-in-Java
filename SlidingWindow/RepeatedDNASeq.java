import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASeq {
  public static void main(String[] args) {
    String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    List<String> res = findRepeatedDnaSequences(s);
    System.out.println(res);
  }

  public static List<String> findRepeatedDnaSequences(String s) {
    int n = s.length();
    Map<String, Integer> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    if (n < 10)
      return res;
    for (int i = 0; i <= n - 10; i++) {
      String currSubString = s.substring(i, i + 10);
      map.put(currSubString, map.getOrDefault(currSubString, 0) + 1);
    }

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() > 1) {
        res.add(entry.getKey());
      }
    }

    return res;
  }
}
