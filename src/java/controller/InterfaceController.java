/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface InterfaceController<T> {
    
    public boolean saveOrUpdate(T t);
    public boolean delete(T t);
    public List<T> getAll();
    public List<T> search(String category, String key);
    public Object getById(Object id);
    public Object getByName(String name);
    public Object getLastId();
    public List<Object> getDataNonExpired(String category);
    public Object getIdPersonal(String id);
}
