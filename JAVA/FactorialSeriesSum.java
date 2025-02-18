import java.util.Scanner;

public class FactorialSeriesSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        double sum = 0.0;

        for (int i = 1; i <= n; i++) {
            sum += 1.0 / factorial(i); 
        }

        System.out.println("The sum of the series is: " + sum);
        
        scanner.close();
    }
    public static int factorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }
}
