import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class p1 {
    public static void main (String [] args) {

	try {
       	    Scanner s = new Scanner(new File("in.txt"));
	    int sum = 0;
	    
	    while(s.hasNextLine()) {
		sum += parseLine(s.nextLine());
	    } //while 
	    
	    System.out.println(sum);
	} catch (FileNotFoundException e) {
	    System.out.println(e);
	} //catch

    } //main

    private static int parseLine(String line) {

	int n = line.length();
	String digits = "";

	for (int i = 0; i < n; i++) {
	    if (Character.isDigit(line.charAt(i))) {
		digits += line.charAt(i);
		break;
	    } //if
	} //for

	for (int i = n - 1; i >= 0; i--) {
	    if (Character.isDigit(line.charAt(i))) {
		digits += line.charAt(i);
		break;
	    } //if
	} //for
	
	return Integer.parseInt(digits);
    } //parseLine
} //p1
