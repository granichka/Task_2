package local.nix.experienceusingclassmy;

import local.nix.experienceusingclassmy.builder.DataBuilder;
import local.nix.experienceusingclassmy.config.ApplicationEnvironment;
import local.nix.experienceusingclassmy.service.EventGuestService;
import local.nix.experienceusingclassmy.service.EventService;
import local.nix.experienceusingclassmy.service.GuestService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataBuilderTest {

    @BeforeAll
    public static void setEnv() {
        ApplicationEnvironment.setPropertyLang("ru");
    }

    @Test
    public void build() {

        DataBuilder dataBuilder = new DataBuilder();
        EventService eventService = dataBuilder.getEventService();
        GuestService guestService = dataBuilder.getGuestService();
        EventGuestService eventGuestService = dataBuilder.getEventGuestService();

        dataBuilder.buildDataList();

        assertTrue(eventService.findAll().size() == 2);
        assertEquals(guestService.findAll().size(), 3);
        assertEquals(eventGuestService.findAll().size(), 3);

        }


    }

