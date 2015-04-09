import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.Locale;


public class Main implements Runnable {
	
	///////////////////////
	// File name variables
	//final String problem = "A";
	 final String problem = "B"; 
	
	// final String filename = problem + "-sample";

	//final String filename = problem + "-small-attempt0";
	//final String filename = problem + "-small-practice";
	final String filename = problem + "-large-practice";
	// final String filename= problem+"-small-attempt1";
	// final String filename= problem+"-large";
	
	// Output Float format
	// e.g. out.write(df.format(T0));
	DecimalFormat df = new DecimalFormat("0.0000000");
	
	//////////////////////////////////////////
	// Hard core function
	public void solve() throws Exception {
//		double C = dread(), F = dread(), X = dread();
//		double factor = 2.0;
//		
//		if (C >= X) {
//			out.write(df.format( X / factor ));
//		} else {
//			double increaseBaseTime = 0.0, delta = 0.0, oldTime, newTime;
//			do {
//				oldTime = increaseBaseTime + X / factor;
//				delta = C / factor;
//				factor += F;
//				increaseBaseTime += delta;
//				newTime = increaseBaseTime + X / factor;
//			} while (oldTime > newTime);
//			out.write(df.format( oldTime ));
//		}
		double C = dread(), F = dread(), X = dread();

		double speed = 2.0;
		double T0 = 0;
		while (C / F < (X - C) / speed) {
			T0 += C / speed;
			speed += F;
		}

		T0 += X / speed;
		out.write(df.format(T0));
	}
	
	
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
			// Helper in-&-out for local test
			//in = new BufferedReader(new InputStreamReader(System.in));
			//out = new BufferedWriter(new OutputStreamWriter(System.out));
			
			// For real file input and output
			in = new BufferedReader(new FileReader(filename + ".in"));
			out = new BufferedWriter(new FileWriter(filename + ".out"));
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
