/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package boundpropertiesnetbean;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author wutic
 */
public class LiveScoreBean implements Serializable {
    
    public static final String SCORE_PROPERTY = "scoreProperty";
    
    private Score scoreLine;
    
    private PropertyChangeSupport propertySupport;
    
    public LiveScoreBean() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public String getScoreLineProperty() {
        return "LIV " + scoreLine.getScoreTeam1() + " : " + scoreLine.getScoreTeam2() + " SEV" ;
    }
    
    public void setScoreLineProperty(int team1Score, int team2Score) {
        Score oldScoreValue = scoreLine;
        scoreLine = new Score(team1Score, team2Score);
        propertySupport.firePropertyChange(SCORE_PROPERTY, oldScoreValue, scoreLine);
    }
    
    public void addSubscripber(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removeSubscripber(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
    public static class Score{
        private final int team1Score;
        private final int team2Score;
        public Score(int scoreTeam1, int scoreTeam2){
            this.team1Score = scoreTeam1;
            this.team2Score = scoreTeam2;
        }
        
        public int getScoreTeam1(){
            return team1Score;
        }
        
        public int getScoreTeam2(){
            return team2Score;
        }
        
        // override toString for call support
        @Override public String toString(){
            return "LIV " + team1Score + " : " + team2Score + " SEV" ;
        }
    }
}
