package local.nix.experienceusingclassmy.service.impl;

import local.nix.experienceusingclassmy.data.Event;
import local.nix.experienceusingclassmy.data.Guest;
import local.nix.experienceusingclassmy.relation.EventGuest;
import local.nix.experienceusingclassmy.repository.EventGuestRepository;
import local.nix.experienceusingclassmy.repository.impl.EventGuestRepositoryImpl;
import local.nix.experienceusingclassmy.service.EventGuestService;

import java.util.List;


public class EventGuestServiceImpl implements EventGuestService {

    private final EventGuestRepository relationRepo = new EventGuestRepositoryImpl();

    public List<Guest> getGuestsOfEvent(String title, String date) {
        return relationRepo.getGuestsOfEvent(title, date);
    }

    public List<Event> getEventsOfGuest(String fullName) {
        return relationRepo.getEventsOfGuest(fullName);
    }

    public void saveOrUpdate(EventGuest eventGuest) {
        if (eventGuest.getId() == null) {
            long id = findAll().size();
            eventGuest.setId(++id);
            relationRepo.save(eventGuest);
        } else {
            relationRepo.update(eventGuest);
        }
    }

    public EventGuest findById(Long id) {
        return relationRepo.findById(id);
    }

    public List<EventGuest> findAll() {
        return relationRepo.findAll();
    }

    public void remove(Long id) {
        relationRepo.remove(id);
    }
}
