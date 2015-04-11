import java.io.*;

import java.awt.geom.Point2D;
import java.text.*;
import java.math.*;
import java.util.*;

public class gcj implements Runnable {
	
	///////////////////////
	// File name variables
	final String problem = "D";
	
	// final String filename = problem + "-sample";

	//final String filename = problem + "-small-attempt0";

	final String filename= problem+"-small-attempt3";
	//final String filename= problem+"-large";
	
	// Output Float format
	// e.g. out.write(df.format(T0));
	//DecimalFormat df = new DecimalFormat("0.000000");
	
	//////////////////////////////////////////
	// Hard core function
	public void solve() throws Exception {
		int X = iread(), R = iread(), C = iread();
		String playerLose = "RICHARD", playerWin = "GABRIEL"; 
		
		if (X == 1) {
			out.write(playerWin);
			return;
		}
		
		// Filled with holes
		if ((R * C) % X != 0 || (R * C) < X) {
			out.write(playerLose);
			return;
		}
		
//		if (X == 2) {
//			out.write(playerWin);
//			return;
//		}
		
		if ((R == 1 || C == 1) && X > 2) {
			out.write(playerLose);
			return;
		}

		if (X == 4) {
			if ((R == 3 && C == 4) || (R == 4 && C == 3) || (R == 4 && C == 4)) {
				out.write(playerWin);
				return;
			}
			out.write(playerLose);
			return;
		}
		
		out.write(playerWin);
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
		new Thread(new gcj()).start();
	}
}
