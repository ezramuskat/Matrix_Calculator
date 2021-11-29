import java.util.*;
public class MatrixCalculator {
	//Error messages
	static String unsupErr = "Sorry, that isn't a supported operation.";

	//set up global Scanner
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String[] keywords = new String[] {"matrix", "mulitply", "q", "operations"}; //holds a list of all supported operations

		//input loop
		boolean end = false;

		while (!end) {
			System.out.print(">");
			String operation = input.nextLine();
			switch (operation) {
				case "matrix":
					double[][] newMatrix = matrixMaker(input);
					for (int i=0; i < newMatrix.length; i++) {
						for (int j=0; j < newMatrix[i].length; j++) {
							System.out.print(newMatrix[i][j] + " ");
						}
						System.out.println();
					}
					break;
				case "multiply":
					while (true) {
						double[][] matrix1 = matrixMaker(input);
						double[][] matrix2 = matrixMaker(input);
						if (matrix1.length != matrix2[0].length) {
							System.out.print("Please enter two matrices of valid dimensions.\n>");
						} else {
							printMatrix(matrixProduct(matrix1, matrix2));
							break;
						}
					}
					break;
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

	public static double[][] matrixMaker(Scanner input) {
		String valDimenErr = "Please enter two whole numbers.\n>";
		String dimMismatchError = "That line is not compatible with your chosen dimensions";
		String numLineErr = "Please enter a series of numbers\n>";

		//Get the dimensions from the user
		System.out.print("Please enter the dimensions of your matrix.\n>");
		int dim1; 
		int dim2;
		while(true) {
			try {
				String line = input.nextLine();
				String[] dimensions = line.split(" ");

				if (dimensions.length != 2) {
					System.out.print(valDimenErr);
				} else {
					dim1 = Integer.parseInt(dimensions[0]);
					dim2 = Integer.parseInt(dimensions[1]);
					break;
				}
			} catch (NumberFormatException e) {
				System.out.print(valDimenErr);
			}
		}

		double[][] matrix = new double[dim1][dim2];

		//Get the matrix from the user
		System.out.println("Please enter the lines of your matrix, one by one.");
		for (int i=0; i < dim1; i++) {
			while(true) {
				try {
					System.out.print(">");
					String line = input.nextLine();
					String[] dimensions = line.split(" ");

					if (dimensions.length != dim2) {
						System.out.println(dimMismatchError);
					} else {
						for (int j=0; j < dim2; j++) {
							matrix[i][j] = Double.parseDouble(dimensions[j]);
						}
						break;
					}
				} catch (NumberFormatException e) {
					System.out.print(numLineErr);
				}
			}
		}
		return matrix;
	}


	public static double[][] matrixProduct(double[][] matrix1, double[][] matrix2) {
		double[][] finalMatrix = new double[matrix1.length][matrix2[0].length];
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix2[0].length; j++) {
				finalMatrix[i][j] = 0;
				for (int k = 0; k < matrix1[0].length; k++) {
					finalMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
				}
				
			}
		}

		return finalMatrix;
	}

	public static void printMatrix(double[][] matrix) {
		for (int i=0; i < matrix.length; i++) {
			for (int j=0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}


}