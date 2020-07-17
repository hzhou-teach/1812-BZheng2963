/*
Bill Zheng
Time: 1 hour
USACO Test Cases: **********
1-10 Difficulty: 5, have to write the correct code
Reflection: I had the idea of running through all possibilities from the very start, but I failed to code it correctly until I looked
	at a previous submission I wrote for this problem. I accidently wrote my loops incorrectly and put code in places they weren't supposed
	to be in. I think I just wasn't diligent enough to run through my own code and find the error.
 */

import java.io.*;
import java.util.*;

public class backforth_1812_bronze {
//--------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("backforth.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
//--------------------------------------------------------------------------------------------------------------------------
		int[] first = new int[10];
		int[] second = new int[11];
		int[] firstcopy = new int[10];
		int[] secondcopy = new int[11];
		//copies used to maintain the original state even after changes
		for (int i = 0; i < 10; i++) {
			firstcopy[i] = scan.nextInt();
			first[i] = firstcopy[i];
		}
		for (int i = 0; i < 10; i++) {
			secondcopy[i] = scan.nextInt();
			second[i] = secondcopy[i];
		}
//--------------------------------------------------------------------------------------------------------------------------
		ArrayList<Integer> totals = new ArrayList<Integer>(); //list of distinct totals
		int total = 1000;
		
		//just run through all cases
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 11; j++) {
				for (int k = 0; k < 10; k++) {
					for (int l = 0; l < 11; l++) {
						total = 1000;
						for (int ind = 0; ind < 10; ind++) { //reset all buckets at the start
							first[ind] = firstcopy[ind];
							second[ind] = secondcopy[ind];
						}
						//simulate carrying buckets over
						second[10] = first[i];
						total -= first[i];
						
						first[i] = second[j];
						total += second[j];
						
						second[j] = first[k];
						total -= first[k];
						
						first[k] = second[l];
						total += second[l];
						
						if (!totals.contains(total)) totals.add(total); //add totals to list if it is unique
					}
				}
			}
		}
//--------------------------------------------------------------------------------------------------------------------------
		out.println(totals.size()); //print number of unique totals

		out.close();
		scan.close();
	}
}
