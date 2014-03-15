package com.pe.cms.yanbal.base;

public interface GenericService<E> {          
    void persist(E e);
    void merge(E e);
    void remove(Object id);
    E findById(Object id);
}
