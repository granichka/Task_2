package local.nix.experienceusingclassmy.repository;

import local.nix.experienceusingclassmy.data.Event;
import local.nix.experienceusingclassmy.data.Guest;
import local.nix.experienceusingclassmy.relation.EventGuest;

import java.util.List;
import java.util.Map;

public interface EventGuestRepository extends AbstractRepository<EventGuest>{

    public List<Guest> getGuestsOfEvent(String title, String date);
    public List<Event> getEventsOfGuest(String fullName);


}
