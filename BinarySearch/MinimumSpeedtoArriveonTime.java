public class MinimumSpeedtoArriveonTime {
    public static void main(String[] args) {
        int[] dist = { 1, 3, 2 };
        double hour = 1.9;
        System.out.println(MinSpeed(dist, hour));
    }

    private static int MinSpeed(int[] dist, double hour) {
        int start = 1;
        int end = 10000000;
        int ans = -1;
        while (end >= start) {
            int checkSpeed = start + (end - start) / 2;
            if (calculatetime(dist, checkSpeed) <= hour) {
                end = checkSpeed - 1;
            } else {
                start = checkSpeed + 1;
            }
        }
        return ans;
    }

    public static double calculatetime(int[] dist, int checkSpeed) {
        double timetaken = 0;
        for (int i = 0; i < dist.length; i++) {
            if (i == dist.length - 1) {
                timetaken += (double) dist[i] / checkSpeed; // last segment
            } else {
                timetaken += (dist[i] + checkSpeed - 1) / checkSpeed; // other segments
            }
        }
        return timetaken;
    }
}
