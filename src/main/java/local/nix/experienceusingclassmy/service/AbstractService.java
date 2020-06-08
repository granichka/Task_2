package local.nix.experienceusingclassmy.service;

import local.nix.experienceusingclassmy.data.AbstractData;

import java.util.List;

public interface AbstractService<T extends AbstractData> {

    void saveOrUpdate(T t);
    T findById(Long id);
    List<T> findAll();
    void remove(Long id);
}
