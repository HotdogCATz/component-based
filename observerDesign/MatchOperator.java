package observerDesign;

/**
 * MatchController
 */
public class MatchOperator extends MatchSource {
    MatchScore matchScore = new MatchScore();

    public void setMatchScore(int teamA, int teamB) {
        matchScore.setTeamAScore(teamA);
        matchScore.setTeamBScore(teamB);
        notifier();
    }

    public MatchScore getMatchScore() {
        return matchScore;
    }
}

class MatchScore {
    private int teamAScore;
    private int teamBScore;

    public int getTeamAScore() {
        return teamAScore;
    }

    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }

    public int getTeamBScore() {
        return teamBScore;
    }

    public void setTeamBScore(int teamBScore) {
        this.teamBScore = teamBScore;
    }

}