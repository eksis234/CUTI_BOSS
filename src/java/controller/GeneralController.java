/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.GeneralDAO;
import daos.InterfaceDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Departemen;
import models.Karyawan;
import models.Role;
import org.hibernate.SessionFactory;

/**
 *
 * @author Lenovo
 * @param <T>
 */
public class GeneralController<T> implements InterfaceController<T>{

    private final SessionFactory factory;
    private final InterfaceDAO idao;
    
    public GeneralController(SessionFactory sessionFactory, Class type) {
        this.factory = sessionFactory;
        this.idao = new GeneralDAO(sessionFactory, type);
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<T> getAll(){
        return this.casTot(idao.getAll());
    }
    
    private List<T> casTot(List<Object> allData){
        List<T> datas = new ArrayList<>();
        allData.stream().map((object) -> (T) object).forEachOrdered((t) -> {
            datas.add(t);
        });
        return datas;
    }
    
    @Override
    public boolean saveOrUpdate(T t){
        return idao.saveOrUpdate(t);
    }
    
    @Override
    public boolean delete(T t){
        return idao.delete(t);
    }
    
    @Override
    public List<T> search(String category, String key){
        return this.casTot(idao.search(category, key));
    }
    
    @Override
    public T getById(Object id){
        return (T) idao.getById(id);
    }

    @Override
    public Object getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getLastId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getDataNonExpired(String category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getIdPersonal(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //(String idKaryawan, String namaKaryawan, String noTlpKaryawan, String emailKaryawan, Date awalGabung, String idManager, String kataSandi, int sisaCuti, int banyakCuti, byte[] foto, String status, Departemen idDepartemen, Role idRole)
    public boolean saveOrUpdateKar(String idKaryawan, String namaKaryawan,
            String noTlpKaryawan, String emailKaryawan, String awalGabung, 
            String idManager, String kataSandi, String sisaCuti, String banyakCuti, 
            String foto, String status, String idDepartemen, String idRole){
        Departemen departemen = new Departemen(idDepartemen);
        Role role = new Role(idRole);
        Karyawan karyawan;
        karyawan = new Karyawan(idKaryawan, 
                namaKaryawan, noTlpKaryawan, emailKaryawan,
                new Date (awalGabung), idManager, kataSandi, new Integer(sisaCuti),
                new Integer(banyakCuti), foto.getBytes(), status, departemen, role);
        System.out.println("karyawan get : "+karyawan.getNamaKaryawan()+" - dept"
                +karyawan.getIdDepartemen().getNamaDepartemen()+" - "+karyawan.getIdRole().getNamaRole());
        return idao.saveOrUpdate(karyawan);
    }
    
    public boolean updateKar(String idKaryawan, String namaKaryawan,
            String noTlpKaryawan, String emailKaryawan, String awalGabung, 
            String idManager, String sisaCuti, String banyakCuti, 
            String foto, String status, String idDepartemen, String idRole){
        Departemen departemen = new Departemen(idDepartemen);
        Role role = new Role(idRole);
        Karyawan karyawan;
        karyawan = new Karyawan(idKaryawan, 
                namaKaryawan, noTlpKaryawan, emailKaryawan,
                new Date (awalGabung), idManager, new Integer(sisaCuti),
                new Integer(banyakCuti), foto.getBytes(), status, departemen, role);
        System.out.println("karyawan get : "+karyawan.getNamaKaryawan()+" - dept"
                +karyawan.getIdDepartemen().getNamaDepartemen()+" - "+karyawan.getIdRole().getNamaRole());
        return idao.saveOrUpdate(karyawan);
    }
}
