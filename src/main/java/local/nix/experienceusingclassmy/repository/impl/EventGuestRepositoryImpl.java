package local.nix.experienceusingclassmy.repository.impl;

import local.nix.experienceusingclassmy.data.Event;
import local.nix.experienceusingclassmy.data.Guest;
import local.nix.experienceusingclassmy.relation.EventGuest;
import local.nix.experienceusingclassmy.repository.EventGuestRepository;


import java.util.ArrayList;
import java.util.List;


public class EventGuestRepositoryImpl implements EventGuestRepository {


    List<EventGuest> relations = new ArrayList<EventGuest>();


    public List<Guest> getGuestsOfEvent(String title, String date) {
        List<Guest> result = new ArrayList<Guest>();
        for(EventGuest relation: relations) {
            if(title.equals(relation.getEvent().getTitle()) && date.equals(relation.getEvent().getDate())) {
                result.add(relation.getGuest());
            }
        }

        return result;
    }

    public List<Event> getEventsOfGuest(String fullName) {
        List<Event> result = new ArrayList<Event>();
        for(EventGuest relation: relations) {
            if(fullName.equals(relation.getGuest().getFullName())) {
                result.add(relation.getEvent());
            }
        }
        return result;
    }


    public void save(EventGuest eventGuest) {
         if (eventGuest != null) {
             relations.add(eventGuest);
         }
    }

    public EventGuest findById(Long id) {
        for(EventGuest relation: relations) {
            if(relation.getId().equals(id)) {
                return relation;
            }
        }

        return null;
    }

    public List<EventGuest> findAll() {
        return relations;
    }

    public void update(EventGuest eventGuest) {
           for(EventGuest relation: relations) {
               if(relation.getId().equals(eventGuest.getId())) {
                   relation.setRelation(eventGuest.getEvent(), eventGuest.getGuest());
               }
           }
    }

    public void remove(Long id) {
        for(int i=0; i < relations.size(); i++) {
            EventGuest relation = relations.get(i);
            if(relation.getId().equals(id)) {
                relations.remove(i);
            }
        }
    }
}
