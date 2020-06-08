package local.nix.experienceusingclassmy.relation;

import local.nix.experienceusingclassmy.data.AbstractData;

import java.util.Map;

public interface AbstractRelation<T1 extends AbstractData<T1>, T2 extends AbstractData<T2>>  {

    public void setRelation(T1 key1, T2 key2);
    public Map<T1, T2> getRelation();

}
