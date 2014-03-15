package com.pe.cms.yanbal.base;

public interface GenericDao<E> {
    void persist(E e) throws Exception;
    void merge(E e) throws Exception;
    void remove(Object id) throws Exception;
    E findById(Object id) throws Exception;     
}
