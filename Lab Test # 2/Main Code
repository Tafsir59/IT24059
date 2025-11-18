import java.io.*;
import java.util.*;
public class MathPuzzle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter difficulty (easy / medium / hard): ");
        String difficulty = input.nextLine().toLowerCase();

        int questionsToAsk = 5;
        if (difficulty.equals("medium")) questionsToAsk = 7;
        else if (difficulty.equals("hard")) questionsToAsk = 10;

        int score = 0;

        try {
            File qFile = new File("questions.txt");
            Scanner qReader = new Scanner(qFile);

            List<String> questions = new ArrayList<>();
            List<Integer> answers = new ArrayList<>();

            while (qReader.hasNextLine()) {
                String line = qReader.nextLine();
                String[] parts = line.split("=");
                questions.add(parts[0].trim());
                answers.add(Integer.parseInt(parts[1].trim()));
            }

            qReader.close();

            for (int i = 0; i < questionsToAsk && i < questions.size(); i++) {
                System.out.print(questions.get(i) + "= ");
                int userAns = input.nextInt();

                if (userAns == answers.get(i)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong! Correct answer: " + answers.get(i));
                }
            }

            FileWriter writer = new FileWriter("score.txt", true);
            writer.write(name + " | Difficulty: " + difficulty + " | Score: " + score + "\n");
            writer.close();

            System.out.println("\nGame Over! Your score has been saved.");

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
