import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.*;


public class Main implements Runnable {

    ///////////////////////
    // File name variables
//    final String problem = "A";
//    final String problem = "B";
    final String problem = "C";
//    final String problem = "D";

    // final String filename = problem + "-sample";

    final String filename = problem + "-small-attempt0";
//    final String filename = problem + "-small-practice";
//    final String filename = problem + "-large-practice";
//     final String filename= problem+"-small-attempt1";
//     final String filename= problem+"-large";

    // Output Float format
    // e.g. out.write(df.format(T0));
    DecimalFormat df = new DecimalFormat("0.0000000");

    //////////////////////////////////////////
    // Hard core function
    public void solve() throws Exception {
        String s = readLine();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(String.valueOf(s.charAt(i))))
                map.put(String.valueOf(s.charAt(i)),1);
            else{
                int num = map.get(String.valueOf(s.charAt(i)));
                map.put(String.valueOf(s.charAt(i)), num + 1);
            }
        }
        HashMap<String,String> numCode = new HashMap<String,String>();
        numCode.put("Z", "ZERO");
        numCode.put("G", "EIGHT");
        numCode.put("W", "TWO");
        numCode.put("X", "SIX");
        numCode.put("O", "ONE");
        numCode.put("V", "SEVEN");
        numCode.put("I", "NINE");
        numCode.put("F", "FIVE");
        numCode.put("R", "THREE");
        numCode.put("U", "FOUR");
        HashMap<String,Integer> numRef = new HashMap<String,Integer>();
        numRef.put("Z", 0);
        numRef.put("G", 8);
        numRef.put("W", 2);
        numRef.put("X", 6);
        numRef.put("O", 1);
        numRef.put("V", 7);
        numRef.put("I", 9);
        numRef.put("F", 5);
        numRef.put("R", 3);
        numRef.put("U", 4);
        ArrayList<Integer> ret= new ArrayList<Integer>();
        String [] logicOrder = {"X","Z","G","U","W","F","I","R","O","V"};
        for(int i=0;i<logicOrder.length;i++){

            while(map.containsKey(logicOrder[i])&&map.get(logicOrder[i])>0){
                for (int j = 0; j < numCode.get(logicOrder[i]).length(); j++) {
                    int count = map.get(String.valueOf(numCode.get(logicOrder[i]).charAt(j))) - 1;
                    map.put(String.valueOf(numCode.get(logicOrder[i]).charAt(j)), count);
                }
                ret.add(numRef.get(logicOrder[i]));
            }

        }
        Collections.sort(ret);
        StringBuilder st = new StringBuilder();
        for(Integer i: ret) {
            st.append(String.valueOf(i));
        }
        out.write(st.toString());
    }

//    private long calPower(int K, int C) {
//        long result = 1;
//        for (int i = 0; i < C; i++) {
//            result *= K;
//        }
//        return result;
//    }

    //////////////////////////////////////////
    /// Helper functions
    public void solve_gcj() throws Exception {

        int tests = iread();
        for (int test = 1; test <= tests; test++) {
            out.write("Case #" + test + ": ");
            solve();
            out.write("\n");
        }
    }

    public void run() {
        try {
//            // Helper in-&-out for local test
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

    public String readLine() throws IOException {
        StringBuilder b = new StringBuilder();
        int c;
        c = in.read();
        while (c != '\n') {
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


