import java.util.ArrayList;
import java.util.List;

public class RestoreIp {
    public static void main(String[] args) {
        String s = "25525511135";
        List<String> res = new ArrayList<>();
        restoreIpAddresses();
    }

    private static void restoreIpAddresses(String s, int i, StringBuilder curr, List<String> res, int countOfDots,
            int currLen) {
        if (i == s.length() && countOfDots == 3) {
            res.add(curr.toString());
            return;
        }

    }
}
