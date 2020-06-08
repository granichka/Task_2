package local.nix.experienceusingclassmy;


import local.nix.experienceusingclassmy.builder.DataBuilder;
import local.nix.experienceusingclassmy.config.ApplicationEnvironment;
import local.nix.experienceusingclassmy.data.Event;
import local.nix.experienceusingclassmy.service.EventService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventServiceTest {

    public static DataBuilder dataBuilder = new DataBuilder();
    EventService eventService = dataBuilder.getEventService();

    @BeforeAll
    public static void build() {

        dataBuilder.buildDataList();
    }


    @BeforeAll
    public static void setEnv() {

        ApplicationEnvironment.setPropertyLang("ru");

    }


    @Test
    public void findAllMethodTest() {

        assertEquals(eventService.findAll().size(), 2);
    }


    @Test
    public void findByIdMethodTest() {

        assertEquals(eventService.findById(2l).getTitle(), "Atlas Weekend 2020");


    }

    @Test
    public void findByTitleMethodTest() {

        assertEquals(eventService.findByTitle("Atlas Weekend 2020").getId(), 2);

    }

    @Test
    public void findByDateMethodTest() {

        assertEquals(eventService.findByDate("20.05.2020").size(), 1);
    }

    @Test
    public void saveOrUpdateMethodTest() {

        Event event = new Event();
        event.setTitle("Bubbles party");
        event.setDate("15.07.2020");
        event.setAddress("Аркадия, Одесса");

        eventService.saveOrUpdate(event);
        assertEquals(eventService.findAll().size(), 3);
        eventService.remove(3l);

    }



    @Test
    public void removeMethodTest() {

        Event event = new Event();
        event.setTitle("Bubbles party");
        event.setDate("15.07.2020");
        event.setAddress("Аркадия, Одесса");

        eventService.saveOrUpdate(event);
        eventService.remove(3l);
        assertEquals(eventService.findAll().size(), 2);


    }





}
