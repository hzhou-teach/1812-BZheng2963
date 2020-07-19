/*
Bill Zheng
Time: 5 min
USACO Test Cases: **********
1-10 Difficulty: 1
Reflection: If you know the solution/how the problem works, the code is super easy.
 */

import java.io.*;
import java.util.*;

public class blist_1812_bronze {
//--------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("blist.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
//--------------------------------------------------------------------------------------------------------------------------
		int N = scan.nextInt();
		int[] time = new int[1001];
		
		for (int i = 0; i < N; i++) {
			int start = scan.nextInt();
			int end = scan.nextInt();
			int b = scan.nextInt();
			for (int j = start; j <= end; j++) {
				time[j] += b;
			}
		}
//--------------------------------------------------------------------------------------------------------------------------
		int ret = Integer.MIN_VALUE;
		for (int i = 0; i < time.length; i++) {
			if (time[i] > ret) {
				ret = time[i];
			}
		}
//--------------------------------------------------------------------------------------------------------------------------
		out.println(ret);

		out.close();
		scan.close();
	}
}
