package eventModel;

import java.util.ArrayList;

public class ScoreSource {
    private ArrayList<ScoreListener> listeners;

    public ScoreSource() {
        listeners = new ArrayList<>();
    }

    // set new score
    public void setScoreLine(int livScore, int sevScore) {
        eventUpdate(new ScoreEvent(this, livScore, sevScore));
    }

    // regis and remove Subscriber
    public void addSubscriber(ScoreListener sl) {
        listeners.add(sl);
    }

    public void removeSubscriber(ScoreListener sl) {
        listeners.remove(sl);
    }

    // send event update to Subscriber
    public void eventUpdate(ScoreEvent scoreEvt) {
        for (int i = 0; i < listeners.size(); i++) {
            ScoreListener sl = listeners.get(i);
            sl.scoreChange(scoreEvt);
            ;
        }
    }

}


