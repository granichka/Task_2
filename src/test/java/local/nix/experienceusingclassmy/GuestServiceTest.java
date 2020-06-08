package local.nix.experienceusingclassmy;

import local.nix.experienceusingclassmy.builder.DataBuilder;
import local.nix.experienceusingclassmy.config.ApplicationEnvironment;
import local.nix.experienceusingclassmy.data.Event;
import local.nix.experienceusingclassmy.data.Guest;
import local.nix.experienceusingclassmy.service.GuestService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuestServiceTest {

    public static DataBuilder dataBuilder = new DataBuilder();
    GuestService guestService = dataBuilder.getGuestService();

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

        assertEquals(guestService.findAll().size(), 3);
    }

    @Test
    public void findByIdMethodTest() {

        assertEquals(guestService.findById(1l).getFullName(), "Кириченко Анастасия Максимовна");
    }

    @Test
    public void findByNameMethodTest() {

        assertEquals(guestService.findByName("Кириченко Анастасия Максимовна").getId(), 1);
    }

    @Test
    public void findByEmailMethodTest() {

        assertEquals(guestService.findByEmail("kirichenko@gmail.com").getId(), 1);
    }

    @Test
    public void saveOrUpdateMethodTest() {
        Guest guest = new Guest();
        guest.setFullName("Сидоров Максим Викторович");
        guest.setEmail("sidorov@gmail.com");
        guest.setPhone("+380984578121");

        guestService.saveOrUpdate(guest);
        assertEquals(guestService.findAll().size(), 4);
        guestService.remove(4l);
    }

    @Test
    public void removeMethodTest() {
        Guest guest = new Guest();
        guest.setFullName("Сидоров Максим Викторович");
        guest.setEmail("sidorov@gmail.com");
        guest.setPhone("+380984578121");

        guestService.saveOrUpdate(guest);
        guestService.remove(4l);
        assertEquals(guestService.findAll().size(), 3);
    }

}
