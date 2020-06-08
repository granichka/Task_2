package local.nix.experienceusingclassmy.repository.impl;

import local.nix.experienceusingclassmy.data.Event;
import local.nix.experienceusingclassmy.data.Guest;
import local.nix.experienceusingclassmy.repository.GuestRepository;

import java.util.ArrayList;
import java.util.List;

public class GuestRepositoryImpl implements GuestRepository {

    List<Guest> guestList = new ArrayList<Guest>();

    public Guest findByName(String name) {
        for(Guest guest: guestList) {
            if(name.equals(guest.getFullName())) {
                return guest;
            }
        }

        return null;
    }

    public Guest findByEmail(String email) {
        for(Guest guest: guestList) {
            if(email.equals(guest.getEmail())) {
                return guest;
            }
        }

        return null;
    }

    public void save(Guest guest) {
            guestList.add(guest);
    }

    public Guest findById(Long id) {
        for(Guest guest: guestList) {
            if(id.equals(guest.getId())) {
                return guest;
            }
        }

        return null;
    }

    public List<Guest> findAll() {
        return guestList;
    }

    public void update(Guest guest) {
        for(Guest currentGuest: guestList) {
            if(guest.getId().equals(currentGuest.getId())) {
                currentGuest.setFullName(guest.getFullName());
                currentGuest.setEmail(guest.getEmail());
                currentGuest.setPhone(guest.getPhone());
            }
        }
    }

    public void remove(Long id) {
        for(int i=0; i < guestList.size(); i++) {
            Guest guest = guestList.get(i);
            if(guest.getId().equals(id)) {
                guestList.remove(i);
            }
        }
    }
}
