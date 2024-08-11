package eventModel;

public class ScoreEvent {
    private Score scoreValue;
    
    public ScoreEvent(Object source, int scoreTeam1, int scoreTeam2){
        super();
        scoreValue = new Score(scoreTeam1, scoreTeam2);
    }

    public Score getScoreValue(){
        return scoreValue;
    }
}
