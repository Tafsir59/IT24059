import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileSeriesOperation {

    public static void main(String[] args) throws Exception {

        File inputFile = new File("input.txt");
        Scanner sc = new Scanner(inputFile);

        int sum = 0;
        int max = Integer.MIN_VALUE;

        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            sum += num;

            if (num > max) {
                max = num;
            }
        }

        sc.close();

        PrintWriter pw = new PrintWriter("output.txt");
        pw.println("Highest Value: " + max);
        pw.println("Sum: " + sum);
        pw.close();
    }
}
