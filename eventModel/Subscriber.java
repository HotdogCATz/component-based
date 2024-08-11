package eventModel;

public class Subscriber implements ScoreListener{
    @Override
    public void scoreChange(ScoreEvent se) {
        System.out.println("live result: LIV " + se.getScoreValue().getLivScore() + " : " + se.getScoreValue().getSevScore() + " SEV");
    }
    
}
