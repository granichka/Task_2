package local.nix.experienceusingclassmy;

import local.nix.experienceusingclassmy.builder.DataBuilder;
import local.nix.experienceusingclassmy.config.ApplicationEnvironment;
import local.nix.experienceusingclassmy.data.Event;
import local.nix.experienceusingclassmy.data.Guest;
import local.nix.experienceusingclassmy.relation.EventGuest;
import local.nix.experienceusingclassmy.service.EventGuestService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventGuestServiceTest {

    public static DataBuilder dataBuilder = new DataBuilder();
    EventGuestService eventGuestService = dataBuilder.getEventGuestService();

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

        assertEquals(eventGuestService.findAll().size(), 3);
    }

    @Test
    public void findByIdMethodTest() {

        assertEquals(eventGuestService.findById(1l).getGuest().getFullName(), "Кириченко Анастасия Максимовна");
    }

    @Test
    public void getGuestsOfEventMethodTest() {

        assertEquals(eventGuestService.getGuestsOfEvent("Atlas Weekend 2020", "06.07.2020").size(), 2);

    }

    @Test
    public void getEventsOfGuestMethodTest() {

        assertEquals(eventGuestService.getEventsOfGuest("Кириченко Анастасия Максимовна").size(), 1);
    }

    @Test
    public void saveOrUpdateMethodTest() {

        EventGuest relation = new EventGuest();

        Event event = new Event();
        event.setTitle("Bubbles party");
        event.setDate("15.07.2020");
        event.setAddress("Аркадия, Одесса");

        Guest guest = new Guest();
        guest.setFullName("Сидоров Максим Викторович");
        guest.setEmail("sidorov@gmail.com");
        guest.setPhone("+380984578121");

        relation.setRelation(event, guest);
        eventGuestService.saveOrUpdate(relation);
        assertEquals(eventGuestService.findAll().size(), 4);
        eventGuestService.remove(4l);

    }

    @Test
    public void removeMethodTest() {

        EventGuest relation = new EventGuest();

        Event event = new Event();
        event.setTitle("Bubbles party");
        event.setDate("15.07.2020");
        event.setAddress("Аркадия, Одесса");

        Guest guest = new Guest();
        guest.setFullName("Сидоров Максим Викторович");
        guest.setEmail("sidorov@gmail.com");
        guest.setPhone("+380984578121");

        relation.setRelation(event, guest);
        eventGuestService.saveOrUpdate(relation);
        eventGuestService.remove(4l);
        assertEquals(eventGuestService.findAll().size(), 3);
    }


}
