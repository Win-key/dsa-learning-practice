package general;

/**
 * This problem was asked by Dropbox.
 * <p>
 * Spreadsheets often use this alphabetical encoding for its columns: "A", "B", "C", ..., "AA", "AB", ..., "ZZ", "AAA", "AAB", ....
 * <p>
 * Given a column number, return its alphabetical column id.
 * For example, given 1, return "A".
 * Given 27, return "AA".
 * Given 28, return "AB".
 */

public class ExcelsheetColumns {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solve(26);
        System.out.println(sb.toString());
        sb.setLength(0);
        solve(1015);
        System.out.println(sb.toString());
        sb.setLength(0);
        solve(78);
        System.out.println(sb.toString());
        sb.setLength(0);
        solve(1106);
        System.out.println(sb.toString());
        sb.setLength(0);
        solve(1099);
        System.out.println(sb.toString());
        sb.setLength(0);
        solve(1014);
        System.out.println(sb.toString());
        sb.setLength(0);
        solve(1014);
        System.out.println(sb.toString());
        sb.setLength(0);
    }

    public static void solve(int n) {
        if (n == 0) {
            return;
        }
        solve((n - 1) / 26);
        sb.append((char) (65 + ((n - 1) % 26)));
    }

}
