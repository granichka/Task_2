package local.nix.experienceusingclassmy.repository.impl;

import local.nix.experienceusingclassmy.data.Event;
import local.nix.experienceusingclassmy.repository.EventRepository;

import java.util.ArrayList;
import java.util.List;

public class EventRepositoryImpl implements EventRepository {

    private final List<Event> eventList = new ArrayList<Event>();


    public List<Event> findByDate(String date) {
        List<Event> result = new ArrayList<Event>();
        for(Event event: eventList) {
            if(date.equals(event.getDate())) {
                result.add(event);
            }
        }

        return result;
    }

    public Event findByTitle(String title) {
        for(Event event: eventList) {
            if(title.equals(event.getTitle())) {
                return event;
            }
        }

        return null;
    }


    public void save(Event event) {

        eventList.add(event);
    }

    public Event findById(Long id) {
        for(Event event: eventList) {
            if(id.equals(event.getId())) {
                return event;
            }
        }

        return null;
    }

    public List<Event> findAll() {
        return eventList;
    }

    public void update(Event event) {
        for(Event currentEvent: eventList) {
            if(event.getId().equals(currentEvent.getId())) {
                currentEvent.setTitle(event.getTitle());
                currentEvent.setAddress(event.getAddress());
                currentEvent.setDate(event.getDate());
            }
        }

    }

    public void remove(Long id) {
        for(int i=0; i < eventList.size(); i++) {
            Event event = eventList.get(i);
            if(event.getId().equals(id)) {
                eventList.remove(i);
            }
        }
    }
}
