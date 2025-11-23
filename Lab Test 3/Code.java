import java.util.Scanner;

// I renamed this class to 'FactorionHelper' to avoid conflicts with your other file
class FactorionHelper {

    // Method to calculate factorial of a digit
    public int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    // Method to check if a number is a Factorion
    public boolean isFactorion(int num) {
        int originalNum = num;
        int sum = 0;
        int temp = num;

        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp = temp / 10;
        }

        return sum == originalNum;
    }

    // Method to find and print factorions in a range
    public void findFactorionsInRange(int start, int end) {
        int count = 0;
        System.out.println("--- Finding Factorion Numbers ---");

        for (int i = start; i <= end; i++) {
            if (isFactorion(i)) {
                System.out.println("Found Factorion: " + i);
                count++;
            }
        }
        System.out.println("---------------------------------");
        System.out.println("Total Factorion numbers found: " + count);
    }
}

public class LabTest3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Updated to use the new class name 'FactorionHelper'
        FactorionHelper utils = new FactorionHelper();

        System.out.print("Enter Start of Range: ");
        int start = scanner.nextInt();

        System.out.print("Enter End of Range: ");
        int end = scanner.nextInt();

        utils.findFactorionsInRange(start, end);

        scanner.close();
    }
}
