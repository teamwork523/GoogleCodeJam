import java.io.*;

import java.awt.geom.Point2D;
import java.text.*;
import java.math.*;
import java.util.*;

public class Solutions {
	
	public void Magic_Trick_2014() throws Exception {
		int firstRowNum = iread();
		int[] firstRow = new int[4];
		int curRead = 0;
		for (int i = 1; i <= 4; i++) {
			for (int j = 0; j < 4; j++) {
				curRead = iread();
				if (firstRowNum == i) {
					firstRow[j] = curRead;
				}
			}
		}
		
		int secondRowNum = iread();
		int[] secondRow = new int[4];
		for (int i = 1; i <= 4; i++) {
			for (int j = 0; j < 4; j++) {
				curRead = iread();
				if (secondRowNum == i) {
					secondRow[j] = curRead;
				}
			}
		}
		
		int countDup = 0;
		int lastDup = -1;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (firstRow[i] == secondRow[j]) {
					countDup++;
					lastDup = firstRow[i];
				}
				
			}
		}
		
		if (countDup == 0) {
			out.write("Volunteer cheated!");
		} else if (countDup > 1) {
			out.write("Bad magician!");
		} else {
			out.write(lastDup+"");
		}
		
	}
}
