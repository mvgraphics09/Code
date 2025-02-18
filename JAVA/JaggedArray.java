import java.util.Scanner;

public class JaggedArray {
    public static void main(String[] args) {
        int[][] a; // Declare jagged array
        int rows, cols; // Variables for rows and columns
        
        Scanner inn = new Scanner(System.in);
        
        // Input number of rows
        System.out.print("How many Rows: ");
        rows = inn.nextInt();
        
        // Initialize the rows
        a = new int[rows][];
        
        // Input values for each row    
        for (int i = 0; i < rows; i++) {
            System.out.print("Enter number of columns for row " + (i + 1) + ": ");
            cols = inn.nextInt(); // Get number of columns for the row
            
            a[i] = new int[cols]; // Initialize the columns
            
            System.out.print("Enter " + cols + " elements for row " + (i + 1) + ": ");
            for (int j = 0; j < cols; j++) {
                a[i][j] = inn.nextInt(); // Input elements
            }
        }

        // Display the array
        System.out.println("Entered Elements:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        
        inn.close(); // Close the scanner
    }
}