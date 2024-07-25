package observerDesign;

import java.util.ArrayList;

public abstract class MatchSource {
    private final ArrayList<Registrant> registrants;

    public MatchSource() {
        this.registrants = new ArrayList<>();
    }

    public final void registerGuest(Registrant guest) {
        registrants.add(guest);
    }

    public final void unregisterGuest(Registrant guest) {
        registrants.remove(guest);
    }

    public final void notifier() {
        for (int i = 0; i < registrants.size(); i++) {
            registrants.get(i).scoreUpdate(this);
        }
    }
}
