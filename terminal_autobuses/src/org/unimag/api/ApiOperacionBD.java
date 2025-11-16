package org.unimag.api;

import java.util.List;

public interface ApiOperacionBD<T, Y> {

    public int getSerial();

    public T inserInto(T objeto, String ruta);

    public T getOne(Y codigo);

    public List<T> selectFrom();
    
    public T updateSet(Y codigo, T objeto, String ruta);

    public Boolean deleteFrom(Y codigo);

    public int numRows();

}
