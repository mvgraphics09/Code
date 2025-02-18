public class SalaryCalculator {
    public static void main(String[] args) {
        double basicSalary = 1000;  

        if (basicSalary > 0) {
            double da = (50 * basicSalary) / 100;
            double hra = (10 * basicSalary) / 100;
            double medical = (4 * basicSalary) / 100;
            double grossSalary = da + hra + medical + basicSalary;
            double incomeTax = (7 * grossSalary) / 100;
            double pf = (5 * grossSalary) / 100;
            double deduction = incomeTax + pf;
            double netSalary = grossSalary - deduction;

            System.out.println("Net Salary is: " + netSalary);
        } else {
            System.out.println("Please enter a valid positive salary.");
        }
    }
}
