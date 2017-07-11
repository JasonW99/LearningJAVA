package c13_DynamicProgramming02;

public class EditDistanceRecur {
    public int solve(String one, String two) {
        return distanceRecur(one, two, one.length(), two.length());
    }

    private int distanceRecur(String one, String two, int i, int j) {
        if (i == 0 || j == 0) {
            return i + j;
        }
        if (one.charAt(i - 1) == two.charAt(j - 1)) {
            return distanceRecur(one, two, i - 1, j - 1);
        }
        int replace = distanceRecur(one, two, i - 1, j - 1) + 1;
        int delete = distanceRecur(one, two, i - 1, j) + 1;
        int insert = distanceRecur(one, two, i, j - 1) + 1;
        return Math.min(replace, Math.min(delete, insert));
    }
}