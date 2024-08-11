package eventModel;

public class Score {
    private int livScore;
    private int sevScore;

    public Score(int livScore, int sevScore) {
        this.livScore = livScore;
        this.sevScore = sevScore;
    }

    public int getLivScore() {
        return livScore;
    }

    public int getSevScore() {
        return sevScore;
    }
}
