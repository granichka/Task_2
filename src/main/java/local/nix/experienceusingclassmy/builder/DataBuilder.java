package local.nix.experienceusingclassmy.builder;

import local.nix.experienceusingclassmy.config.ApplicationEnvironment;
import local.nix.experienceusingclassmy.data.Event;
import local.nix.experienceusingclassmy.data.Guest;
import local.nix.experienceusingclassmy.relation.EventGuest;
import local.nix.experienceusingclassmy.service.EventGuestService;
import local.nix.experienceusingclassmy.service.EventService;
import local.nix.experienceusingclassmy.service.GuestService;
import local.nix.experienceusingclassmy.service.impl.EventGuestServiceImpl;
import local.nix.experienceusingclassmy.service.impl.EventServiceImpl;
import local.nix.experienceusingclassmy.service.impl.GuestServiceImpl;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DataBuilder implements AbstractBuilder{

    private final EventService eventService = new EventServiceImpl();
    private final GuestService guestService = new GuestServiceImpl();
    private final EventGuestService eventGuestService = new EventGuestServiceImpl();

    @Override
    public void buildDataList() {

        for (Map.Entry<String, String> entry : getKeyValueMapByBundleProperties(ApplicationEnvironment.getPropertyLang()).entrySet()) {

            String[] eventData = entry.getKey().split("#");
            Event event = new Event();
            String eventTitleProperties = String.join(" ", eventData[0].split("_"));
            event.setTitle(eventTitleProperties);
            event.setDate(eventData[1]);
            event.setAddress(eventData[2]);
            eventService.saveOrUpdate(event);




            if (entry.getValue().contains(";")) {
                List<String> guestPropertiesList = Arrays.asList(entry.getValue().split(";"));
                guestPropertiesList.forEach(stringOfGuestProperties -> {
                    String[] currentGuestProperties = stringOfGuestProperties.split("#");
                    Guest guest = new Guest();
                    guest.setFullName(String.join(" ", currentGuestProperties[0].split("_")));
                    guest.setEmail(currentGuestProperties[1]);
                    guest.setPhone(currentGuestProperties[2]);
                    guestService.saveOrUpdate(guest);
                    EventGuest relation = new EventGuest();
                    relation.setRelation(event, guest);
                    eventGuestService.saveOrUpdate(relation);

                });
            } else {
                Guest guest = new Guest();
                String guestString = entry.getValue();
                String[] guestProperties = guestString.split("#");
                guest.setFullName(guestProperties[0]);
                guest.setEmail(guestProperties[1]);
                guest.setPhone(guestProperties[2]);
                guestService.saveOrUpdate(guest);
                EventGuest relation = new EventGuest();
                eventGuestService.saveOrUpdate(relation);
            }



            }


        }

    public EventService getEventService() {
        return eventService;
    }

    public GuestService getGuestService() {
        return guestService;
    }

    public EventGuestService getEventGuestService() {
        return eventGuestService;
    }


    }

