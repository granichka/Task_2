package local.nix.experienceusingclassmy.service;

import local.nix.experienceusingclassmy.data.Event;

import java.util.List;

public interface EventService extends AbstractService<Event>{

    List<Event> findByDate(String date);
    Event findByTitle(String title);

}
