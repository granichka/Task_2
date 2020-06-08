package local.nix.experienceusingclassmy.service;

import local.nix.experienceusingclassmy.data.Guest;
import local.nix.experienceusingclassmy.relation.EventGuest;

public interface GuestService extends AbstractService<Guest>{

    Guest findByName(String name);
    Guest findByEmail(String email);
}
