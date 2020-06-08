package local.nix.experienceusingclassmy.repository;

import local.nix.experienceusingclassmy.data.Guest;

public interface GuestRepository extends AbstractRepository<Guest>{

    Guest findByName(String name);
    Guest findByEmail(String email);


}
