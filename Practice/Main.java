import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Locale;


public class Main implements Runnable {

    ///////////////////////
    // File name variables
    final String problem = "A";
//    final String problem = "B";
//    final String problem = "C";

    // final String filename = problem + "-sample";

    //final String filename = problem + "-small-attempt0";
//    final String filename = problem + "-small-practice";
    final String filename = problem + "-large-practice";
    // final String filename= problem+"-small-attempt1";
    // final String filename= problem+"-large";

    // Output Float format
    // e.g. out.write(df.format(T0));
    DecimalFormat df = new DecimalFormat("0.0000000");

    // Helper object
    HashMap<Long, Long> maxDeletedLen = new HashMap<Long, Long>();

    //////////////////////////////////////////
    // Hard core function
    public void solve() throws Exception {
        int R = iread(), C = iread(), N = iread();

        if (N == 0) {
            out.write("0");
            return;
        }
        int result;
        if (R == 1 || C == 1) {
            result = countForOneCase(R * C, N);
        } else if (R == 2 || C == 2) {
            result = countForTwoCase(R * C / 2, N);
        } else {
            result = countForOtherCase(R, C, N);
        }

        out.write(String.valueOf(result));
    }

    private int countForOneCase(int notOneNumber, int N) {
        int mid = 0;
        if (isOddNumber(notOneNumber)) {
            mid = notOneNumber / 2 + 1;
        } else {
            mid = notOneNumber / 2;
        }
        if (N <= mid) {
            return 0;
        } else {
            return (N - mid) * 2;
        }
    }

    private int countForTwoCase(int notTwoNumber, int N) {
        int mid = notTwoNumber;
        if (N <= mid) {
            return 0;
        } else if (N <= mid + 2) {
            return (N - mid) * 2;
        } else {
            return (N - mid - 2) * 3 + 4;
        }
    }

    private int countForOtherCase(int R, int C, int N) {
        if (R * C % 4 != 0) {
            if (N <= R * C / 2) {
                return 0;
            } else if (N <= R * C / 2 + 2) {
                return (N - R * C / 2 ) * 2;
            } else if (N <= (R * C) / 2 + R + C - 2) {
                return (N - R * C / 2 - 2) * 3 + 4;
            } else {
                return 4 * N - 2 * R * C - R - C;
            }
        } else {
            if (N <= R * C / 2 + 1) {
                return 0;
            } else if (N <= (R * C) / 2 + R + C - 1) {
                return (N - R * C / 2 - 1) * 3;
            } else {
                return 4 * N - 2 * R * C - R - C;
            }
        }
    }

    private boolean isOddNumber(int i) {
        return (i % 2) == 1;
    }

    //////////////////////////////////////////
    /// Helper functions
    public void solve_gcj() throws Exception {
        int tests = iread();
        for (int test = 1; test <= tests; test++) {
            out.write("Case #" + test + ": ");
            solve();
            out.write("\n");
            out.flush();
        }
    }

    public void run() {
        try {
            // Helper in-&-out for local test
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new BufferedWriter(new OutputStreamWriter(System.out));

            // For real file input and output
//            in = new BufferedReader(new FileReader(filename + ".in"));
//            out = new BufferedWriter(new FileWriter(filename + ".out"));
            solve_gcj();
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public int iread() throws Exception {
        return Integer.parseInt(readword());
    }

    public double dread() throws Exception {
        return Double.parseDouble(readword());
    }

    public long lread() throws Exception {
        return Long.parseLong(readword());
    }

    BufferedReader in;

    BufferedWriter out;

    public String readword() throws IOException {
        StringBuilder b = new StringBuilder();
        int c;
        c = in.read();
        while (c >= 0 && c <= ' ')
            c = in.read();
        if (c < 0)
            return "";
        while (c > ' ') {
            b.append((char) c);
            c = in.read();
        }
        return b.toString();
    }

    /////////////////////////
    // Main Function
    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception e) {

        }
        new Thread(new Main()).start();
    }
}
