package local.nix.experienceusingclassmy.relation;

import local.nix.experienceusingclassmy.data.AbstractData;
import local.nix.experienceusingclassmy.data.Event;
import local.nix.experienceusingclassmy.data.Guest;

import java.util.HashMap;
import java.util.Map;

public class EventGuest extends AbstractData<EventGuest> implements AbstractRelation<Event, Guest> {

    private Event event = new Event();
    private Guest guest = new Guest();
    private Map<Event, Guest> relation = new HashMap<Event, Guest>();


    public void setRelation(Event key1, Guest key2) {
        if(key1 != null && key2 != null) {
            event = key1;
            guest = key2;
            relation.put(key1, key2);
        }
    }

    public void setEvent(Event key1) {
        this.event = key1;
    }

    public void setGuest(Guest key2) {
        this.guest = key2;
    }

    public Map<Event, Guest> getRelation() {
        return relation;
    }

    public Event getEvent() {
        return event;
    }

    public Guest getGuest() {
        return guest;
    }
}
