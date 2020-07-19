/*
Bill Zheng
Time: 1.5 hour
USACO Test Cases: **********
1-10 Difficulty: 6
Reflection: I couldn't find the correct solution, I just didn't know what to do to approach the problem. I ended up looking at the
	solution and found that binary searching was the correct method which made a lot of sense. I had thought of the solution but
	didn't look too much into it. It would have been hard for me to come up with a solution otherwise. With the solution known,
	the coding wasn't super hard. I tried using methods/functions to write my code because I want to get more used to using them.
 */

import java.io.*;
import java.util.*;

public class convention_1812_silver {
	static int N,M,C;
	static int[] arrivals;
	
	static boolean check(int wait) {
		int start = 0;
		int cars = 1;
		//put cows in cars given the restrictions and see if it works out for the wait time given
		for (int i = 1; i < N; i++) {
			if (arrivals[i]-arrivals[start] > wait || (i+1-start) > C) {
				start = i;
				cars++;
			}
		}
		return (cars <= M);
	}
	
	static int binSearch(int min, int max) {
		if (min == max) return max;
		if (min+1 == max) {
			if (check(min)) {
				return min;
			} else return max;
		}
		
		int mid = (max+min)/2;
		if (check(mid)) {
			return binSearch(min, mid);
		} else return binSearch(mid+1, max);
	}
	
//--------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("convention.in"));
//--------------------------------------------------------------------------------------------------------------------------
		N = scan.nextInt();
		M = scan.nextInt();
		C = scan.nextInt();
		
		arrivals = new int[N];
		for(int i = 0; i < N; i++) {
			arrivals[i] = scan.nextInt();
		}
		Arrays.sort(arrivals);
//--------------------------------------------------------------------------------------------------------------------------
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
		//Time could be anywhere from 0 to 10^9
		System.out.println(binSearch(0,1000000000));
		out.println(binSearch(0,1000000000));

		out.close();
		scan.close();
	}
}
