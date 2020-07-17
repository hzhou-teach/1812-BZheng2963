/*
Bill Zheng
Time: 1 hour 5 min
USACO Test Cases: **********
1-10 Difficulty: 7
Reflection: So basically I did use a lot of resources to help me, online search of flood fill algorithm as well as a previous
	flood fill algorithm that I did. However, implementing and changing the algorithm to fit this problem as well as adding new
	parts to this problem were not particularly hard. Debugging as well wasn't too challenging for me, so overall I think this
	went really well and I am super proud of my performance because I got 10/10 after my first submission!
		It might be a bit messy and I did use the recursive algorithm because it made the most sense to me. If I had more time
	I would have tried the stack/canonical algorithm that Teacher Zhou mentioned in class.
 */

import java.io.*;
import java.util.*;

public class mooyomooyo_1812_silver {
//- GLOBAL VARIABLES ------------------------------------------------------------------------------------------------------
	static int[][] grid;
	static boolean[][] visited;
	static int N;
	static int K;
	static int counter;
//- Main Flood Fill Algorithm ----------------------------------------------------------------------------------------------
	static void floodFillUtil(int g[][], int x, int y, int num, ArrayList<Integer> list) {
	//PARAMETERS: g is grid, x and y are coordinates, num is the current nonzero number, list is the list of coordinates in connected region
		//Base cases where the flood fill returns
		if (x<0 || x>=N || y<0 || y>=10) return;
		if (g[x][y] != num) return;
		if (visited[x][y]) return;
		
		//if the flood fill hasn't returned, then the cell SHOULD BE a part of the region
		list.add(x); //add cell to the list
		list.add(y);
		visited[x][y] = true; //mark cell as visited so we don't go back to the cell
		
		//next visit all neighboring cells
		floodFillUtil(g, x+1, y, num, list);
		floodFillUtil(g, x-1, y, num, list);
		floodFillUtil(g, x, y+1, num, list);
		floodFillUtil(g, x, y-1, num, list);
	}
//- Flood Fill with some add ons -------------------------------------------------------------------------------------------
	static void floodFill(int g[][], int x, int y, int num, ArrayList<Integer> list) {
	//Same parameters as above flood fill algorithm
		floodFillUtil(g, x, y, num, list); //do the flood fill with the given coordinate cell
		if (list.size() >= K*2) { //with the newly generated list of cells in the connected region, check if it's large enough
			for (int i = 0; i < list.size(); i+=2) { 
				grid[list.get(i)][list.get(i+1)] = 0; //if list if large enough, set all cells in the connected region to "0"
			}
			counter++; //checks to see if flood fill changed anything, if no change, the code will stop and we can output
		}
	}
//--------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException {
		//Scanner scan = new Scanner(new File("D:\\eclipse-workspace\\USACO\\Silver\\testSilver.txt"));
		Scanner scan = new Scanner (new File ("mooyomooyo.in"));
//----- INPUT --------------------------------------------------------------------------------------------------------------
		N = scan.nextInt();
		K = scan.nextInt();
		grid = new int[N][10];
		visited = new boolean[N][10];
		ArrayList<Integer> list = new ArrayList<Integer>();
		counter = 1;
		
		for (int i = 0; i < N; i++) {
			String nextrow = scan.next();
			for (int j = 0; j < 10; j++) {
				grid[i][j] = Character.getNumericValue(nextrow.charAt(j));
			}
		}
//----- Flood Fill ------------------------------------------------------------------------------------------------------------------
		while (counter > 0) { //if the grid has no change, then we have our output/final grid
			counter = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 10; j++) {
					if (grid[i][j] != 0 && !visited[i][j]) { //check every nonzero and not visited cell and use flood fill
						floodFill(grid,i,j,grid[i][j],list);
						list.clear();
					}
				}
			}
//--------- Gravity -----------------------------------------------------------------------------------------------------------------
			int index = 0; //index and copy used to move cells down with "gravity"
			int copy = 0;
			for (int j = 0; j < 10; j++) {
				for (int i = N-1; i >= 0; i--) { //looking at columns (vertical)
					if (grid[i][j] != 0) {
						copy = grid[i][j]; //first copy nonzero number
						index = i; //index will be used as a pointer going down like gravity
						grid[i][j] = 0; //set previous grid to 0
						while (index+1 < N && grid[index+1][j] == 0) { //if the grid below is a "0" then gravity moves down to that index
							index++;
						}
						grid[index][j] = copy; //at the end, we go to the lowest 0 index and place the copied nonzero number, then repeat
					}
					visited[i][j] = false; //reset all visited arrays, make them all not visited yet for the next flood fill
				}
			}
		}
//----- OUTPUT ---------------------------------------------------------------------------------------------------------------------
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				out.print(grid[i][j]);
			}
			out.println();
		}

		out.close();
		scan.close();
	}
}
