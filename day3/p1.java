import java.io.File;
import java.util.Scanner;

public class p1 {
    public static void main(String [] args) {
	char [][] data = parseInput();
	int n = data.length, m = data[0].length, sol = 0;
	
	String candidate = "";
	boolean valid = false;
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < m; j++) {
		 if (Character.isDigit(data[i][j])) {
		     candidate += data[i][j];
		     if (!valid) valid = isValid(data, i, j);
		 } else {
		     if (valid && candidate.length() > 0) sol += Integer.parseInt(candidate);
		     
		     candidate = "";
		     valid = false;
		 } //if
	    } //for
 	} //for
	

	System.out.println(sol);
    } //main

    private static boolean isValid(char [][] data, int x, int y) {
	int n = data.length, m = data[0].length;
	//left
	if (x - 1 >= 0 && !(Character.isDigit(data[x - 1][y]) || data[x - 1][y] == '.')) return true;
	//right
	if (x + 1 < n && !(Character.isDigit(data[x + 1][y]) || data[x + 1][y] == '.')) return true;
	//up
	if (y - 1 >= 0 && !(Character.isDigit(data[x][y - 1]) || data[x][y - 1] == '.')) return true;
	//down
	if (y + 1 < m && !(Character.isDigit(data[x][y + 1]) || data[x][y + 1] == '.')) return true;

	//top-left
	if (x - 1 >= 0 && y - 1 >= 0 && !(Character.isDigit(data[x - 1][y - 1]) || data[x - 1][y - 1] == '.')) return true;
	//top-right
	if (x - 1 >= 0 && y + 1 < m && !(Character.isDigit(data[x - 1][y + 1]) || data[x - 1][y + 1] == '.')) return true;
	//bottom-left
	if (x + 1 < n && y - 1 >= 0 && !(Character.isDigit(data[x + 1][y - 1]) || data[x + 1][y - 1] == '.')) return true;
	//bottom-right
	if (x + 1 < n && y + 1 < m && !(Character.isDigit(data[x + 1][y + 1]) || data[x + 1][y + 1] == '.')) return true;

	return false;
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
