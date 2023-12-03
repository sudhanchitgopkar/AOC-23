import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class p2 {
    public static void main(String [] args) {
	char [][] data = parseInput();
	int n = data.length, m = data[0].length;
	long sol = 0;
	
	HashMap <String, List<Integer>> g2n = new HashMap <> (); 
	String candidate = "";
	HashSet <String> gears = new HashSet <> ();
	
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < m; j++) {
		 if (Character.isDigit(data[i][j])) {
		     candidate += data[i][j];
		     String gearRes = isGeared(data, i, j);
		     if (!gearRes.equals("-1")) gears.add(gearRes);
		 } else {
		     if (candidate.length() == 0) continue;
		     int candidateNum = Integer.parseInt(candidate);
		     for (String gear : gears) {
			 if (!g2n.containsKey(gear)) g2n.put(gear, new ArrayList<Integer> ());
			 g2n.get(gear).add(candidateNum);
		     } //for
		     candidate = "";
		     gears.clear();
		 } //if
	    } //for
 	} //for
	
	for (String gear : g2n.keySet()) {
	    if (g2n.get(gear).size() == 2) {
		sol += g2n.get(gear).get(0) * g2n.get(gear).get(1);
	    } //if
	} //for

	System.out.println(sol);
    } //main

    private static String isGeared(char [][] data, int x, int y) {
	int n = data.length, m = data[0].length;
	//left
	if (x - 1 >= 0 && data[x - 1][y] == '*') return "" + (x - 1) + "," + y;
	//right
	if (x + 1 < n && data[x + 1][y] == '*') return "" + (x + 1) + "," + y;
	//up
	if (y - 1 >= 0 && data[x][y - 1] == '*') return "" + x + "," + (y - 1);
	//down
	if (y + 1 < m && data[x][y + 1] == '*') return "" + x + "," + (y + 1);

	//top-left
	if (x - 1 >= 0 && y - 1 >= 0 && data[x - 1][y - 1] == '*') return "" + (x - 1) + "," + (y - 1);
	//top-right
	if (x - 1 >= 0 && y + 1 < m && data[x - 1][y + 1] == '*') return "" + (x - 1) + "," + (y + 1);
	//bottom-left
	if (x + 1 < n && y - 1 >= 0 && data[x + 1][y - 1] == '*') return "" + (x + 1) + "," + (y - 1);
	//bottom-right
	if (x + 1 < n && y + 1 < m && data[x + 1][y + 1] == '*')  return "" + (x + 1) + "," + (y + 1);

	return "-1";
    } //isValid

    
    private static char [][] parseInput() {
	char [][] data;
	try {
	    Scanner s = new Scanner(new File("in.txt"));
	
	    int n = 0, m = 0;

	    while (s.hasNextLine()) {
		//get line, dimensions
		String line = s.nextLine();
		m = line.length();
		++n;
	    } //while
	    
	    data = new char[n][m];
	    s = new Scanner(new File("in.txt"));
	    int currCol = 0, currRow = 0;

	    while (s.hasNextLine()) {
		currCol = 0;
		String line = s.nextLine();
		for (char c : line.toCharArray()) {
		    data[currRow][currCol++] = c;
		} //for
		++currRow;
	    } //while
	
	} catch (Exception e) {
	    System.out.println("Alabama eats shit\n" + e);
	    data = new char [0][0];
	} //catch

	return data;
    } //parse

    private static void print(char [][] a) {
	for (char [] l : a) {
	    for (char c : l) {
		System.out.print(c + " ");
	    } //for
	    System.out.println();
	} //for
    } //print
} //p1
