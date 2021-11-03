import java.util.*;
public class MatrixCalculator {
	//Error messages
	static String unsupErr = "Sorry, that isn't a supported operation.";

	public static void main(String[] args) {
		String[] keywords = new String[] {"q", "operations"}; //holds a list of all supported operations

		Scanner input = new Scanner(System.in);

		//input loop
		boolean end = false;

		while (!end) {
			System.out.print(">");
			String operation = input.nextLine();
			switch (operation) {
				case "q": //quits the program
					end = true;
					break;
				case "operations": //prints out a list of all currently supported operations
					String opString = Arrays.toString(keywords);
					System.out.println(opString.substring(1, opString.length()-1));
					break;
				default:
					System.out.println(unsupErr);
			}
		}
	}
}