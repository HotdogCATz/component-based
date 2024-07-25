package observerDesign;

public class Registrant implements Observer {
    private String name;

    Registrant(String name) {
        this.name = name;
    }

    @Override
    public void scoreUpdate(MatchSource o) {
        MatchScore matchScore = ((MatchOperator) o).getMatchScore();
        System.out.println("(" + name + ")" + " live result is updated: LIV " + matchScore.getTeamAScore() + " : "
                + matchScore.getTeamBScore() + " BET");
    }
}
