package local.nix.experienceusingclassmy.service.impl;

import local.nix.experienceusingclassmy.data.Event;
import local.nix.experienceusingclassmy.repository.EventRepository;
import local.nix.experienceusingclassmy.repository.impl.EventRepositoryImpl;
import local.nix.experienceusingclassmy.service.EventService;

import java.util.List;

public class EventServiceImpl implements EventService {

    private final EventRepository eventRepo = new EventRepositoryImpl();

    public List<Event> findByDate(String date) {

        return eventRepo.findByDate(date);
    }

    public Event findByTitle(String title) {

        return eventRepo.findByTitle(title);
    }

    public void saveOrUpdate(Event event) {
        if (event.getId() == null) {
            long id = findAll().size();
            event.setId(++id);
            eventRepo.save(event);
        } else {
            eventRepo.update(event);
        }
    }

    public Event findById(Long id) {
        return eventRepo.findById(id);
    }

    public List<Event> findAll() {
        return eventRepo.findAll();
    }

    public void remove(Long id) {
            eventRepo.remove(id);
    }
}
