/*
Bill Zheng
Time: 10 min
USACO Test Cases: **********
1-10 Difficulty: 2
Reflection: Easy code, just put one line of code in the wrong order so I had to debug it.
 */

import java.io.*;
import java.util.*;

public class mixmilk_1812_bronze {
//--------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("mixmilk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
//--------------------------------------------------------------------------------------------------------------------------
		int c1 = scan.nextInt();
		int m1 = scan.nextInt();
		int c2 = scan.nextInt();
		int m2 = scan.nextInt();
		int c3 = scan.nextInt();
		int m3 = scan.nextInt();
//--------------------------------------------------------------------------------------------------------------------------
		for (int i = 0; i < 100; i++) {
			if (i % 3 == 0) {
				if (m1+m2>c2) {
					m1 = m1+m2-c2;
					m2 = c2;
				} else {
					m2 = m1+m2;
					m1 = 0;
				}
			}
			if (i % 3 == 1) {
				if (m2+m3>c3) {
					m2 = m2+m3-c3;
					m3 = c3;
				} else {
					m3 = m2+m3;
					m2 = 0;
				}
			}
			if (i % 3 == 2) {
				if (m3+m1>c1) {
					m3 = m3+m1-c1;
					m1 = c1;
				} else {
					m1 = m3+m1;
					m3 = 0;
				}
			}
		}
//--------------------------------------------------------------------------------------------------------------------------
		out.println(m1);
		out.println(m2);
		out.println(m3);

		out.close();
		scan.close();
	}
}
