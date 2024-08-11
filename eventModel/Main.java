package eventModel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            ScoreSource source = new ScoreSource();
            Subscriber sub1 = new Subscriber();
            Subscriber sub2 = new Subscriber();

            source.addSubscriber(sub1);
            source.addSubscriber(sub2);

            // user input
            while (true) {

                System.out.println("Enter score for Team LIV (or press 'Enter' key to quit): ");
                String livScoreInput = sc.nextLine();
                if (livScoreInput.isEmpty()) {
                    break;
                }

                System.out.println("Enter score for Team SEV (or press 'Enter' key to quit): ");
                String sevScoreInput = sc.nextLine();
                if (sevScoreInput.isEmpty()) {
                    break;
                }

                int livScore = Integer.parseInt(livScoreInput);
                int sevScore = Integer.parseInt(sevScoreInput);

                source.setScoreLine(livScore, sevScore);

            }

            sc.close();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid integers for the scores.");
        }
    }
}
