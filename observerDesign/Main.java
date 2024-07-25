package observerDesign;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Registrant guest1 = new Registrant("Registrant 1");
        Registrant guest2 = new Registrant("Registrant 2");

        MatchOperator matchOp = new MatchOperator();

        // Add registrant is not in assignment part kub
        matchOp.registerGuest(guest1);
        matchOp.registerGuest(guest2);

        while (true) {
            System.out.print("Enter score for Team Liverpool (or press 'Enter' key to quit): ");
            String teamAScoreInput = sc.nextLine();
            if (teamAScoreInput.isEmpty()) {
                break;
            }

            System.out.print("Enter score for Team Real Betis (or press 'Enter' key to quit): ");
            String teamBScoreInput = sc.nextLine();
            if (teamBScoreInput.isEmpty()) {
                break;
            }

            try {
                int teamAScore = Integer.parseInt(teamAScoreInput);
                int teamBScore = Integer.parseInt(teamBScoreInput);

                matchOp.setMatchScore(teamAScore, teamBScore);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid integers for the scores.");
            }
        }

        sc.close();

    }
}
