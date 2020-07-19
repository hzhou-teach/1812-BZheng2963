/*
Bill Zheng
Time: 40 min
USACO Test Cases: *********t
1-10 Difficulty: 5 because I can't find the last test case
Reflection: I'd say the solution to this one is pretty simple and the code isn't that difficult either. I started with a bronze
	method and then tried to optimize it. I still couldn't get the last test case but besides that it was fine.
 */

import java.io.*;
import java.util.*;

class Seniority {
	public int a, t;
}

public class convention2_1812_silver {
//--------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException {
		//Scanner scan = new Scanner(new File("D:\\eclipse-workspace\\USACO\\Silver\\testSilver.txt"));
		Scanner scan = new Scanner (new File ("convention2.in"));
//--------------------------------------------------------------------------------------------------------------------------
		int N = scan.nextInt();
		
		ArrayList<Seniority> list = new ArrayList<Seniority>();
		
		for (int i=0; i<N; i++) {
			Seniority cow = new Seniority();
			cow.a = scan.nextInt();
			cow.t = scan.nextInt();
			list.add(cow);
		}
//--------------------------------------------------------------------------------------------------------------------------
		int time = 0;
		int wait = 0;
		int min = Integer.MAX_VALUE;
		boolean found = false;
		//int index = 0;
		
		while (!list.isEmpty()) {
			min = Integer.MAX_VALUE;
			found = false;
			int size = list.size();
			
			for (int i=0; i<size; i++) {
				Seniority cows = new Seniority();
				cows = list.get(i);
				if (cows.a <= time) {
					wait = Math.max(wait, time-cows.a);
					//System.out.println("Time: " + time + "; Wait: " + wait);
					time += cows.t;
					list.remove(i);
					found = true;
					break;
				}
				if (cows.a <= min) {
					min = Math.min(min, cows.a);
				}
			}
			if (!found) {
				time = min;
			}
		}
		
//--------------------------------------------------------------------------------------------------------------------------
		/* Attempt to make faster.
		int time = 0;
		int wait = 0;
		int min = Integer.MAX_VALUE;
		boolean found = false;
		int index = 0;
		
		while (!list.isEmpty()) {
			min = Integer.MAX_VALUE;
			found = false;
			int size = list.size();
			
			for (int i=0; i<size; i++) {
				Seniority cows = new Seniority();
				cows = list.get(i);
				if (cows.a <= time && !found) {
					wait = Math.max(wait, time-cows.a);
					//System.out.println("Time: " + time + "; Wait: " + wait);
					time += cows.t;
					index = i;
					found = true;
					continue;
				}
				if (cows.a <= min) {
					min = Math.min(min, cows.a);
				}
			}
			if (found) list.remove(index);
			if (time < min) {
				time = min;
			}
		}
		*/
//--------------------------------------------------------------------------------------------------------------------------

//--------------------------------------------------------------------------------------------------------------------------
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));
		System.out.println(wait);
		out.println(wait);

		out.close();
		scan.close();
	}
}
