package local.nix.experienceusingclassmy.repository;

import local.nix.experienceusingclassmy.data.Event;

import java.util.List;

public interface EventRepository extends AbstractRepository<Event>{

    List<Event> findByDate(String date);
    Event findByTitle(String title);


}
