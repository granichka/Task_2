package local.nix.experienceusingclassmy.service.impl;

import local.nix.experienceusingclassmy.data.Guest;
import local.nix.experienceusingclassmy.repository.GuestRepository;
import local.nix.experienceusingclassmy.repository.impl.GuestRepositoryImpl;
import local.nix.experienceusingclassmy.service.GuestService;

import java.util.List;

public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepo = new GuestRepositoryImpl();

    public Guest findByName(String name) {
        return guestRepo.findByName(name);
    }

    public Guest findByEmail(String email) {
        return guestRepo.findByEmail(email);
    }

    public void saveOrUpdate(Guest guest) {
        if (guest.getId() == null) {
            long id = findAll().size();
            guest.setId(++id);
            guestRepo.save(guest);
        } else {
            guestRepo.update(guest);
        }
    }

    public Guest findById(Long id) {
        return guestRepo.findById(id);
    }

    public List<Guest> findAll() {
        return guestRepo.findAll();
    }

    public void remove(Long id) {
            guestRepo.remove(id);
    }
}
