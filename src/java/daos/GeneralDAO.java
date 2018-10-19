/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

/**
 *
 * @author Lenovo
 */
public class GeneralDAO implements InterfaceDAO {

    private final FunctionDAO gdao;
    private final Class type;
    private SessionFactory sf;
    private Connection c;

    public GeneralDAO(SessionFactory sessionFactory, Class type) {
        this.gdao = new FunctionDAO(sessionFactory);
        this.type = type;
        this.sf = sessionFactory;
    }

    @Override
    public boolean saveOrUpdate(Object object) {
        return (boolean) gdao.execute(0, object, type, null, null);
    }

    @Override
    public boolean delete(Object object) {
        return (boolean) gdao.execute(1, object, type, null, null);
    }

    @Override
    public List<Object> getAll() {
        return (List<Object>) gdao.execute(6, null, type, null, null);
    }

    @Override
    public List<Object> search(String category, Object key) {
        return (List<Object>) gdao.execute(3, null, type, category, key);
    }

    @Override
    public Object getById(Object id) {
        return gdao.execute(2, null, type, "id"+type.getSimpleName() , id);
    }
    
    @Override
    public Object getIdPersonal(Object id){
        return gdao.execute(2, null, type, "idpersonal", new BigDecimal(id+""));
    }

    @Override
    public Object getLastId() {
        return gdao.execute(4, null, type, null, null);
    }

    @Override
    public Object getByName(Object name) {
        return gdao.execute(5, null, type, type.getSimpleName().toLowerCase() + "Name", name);
    }

    @Override
    public List<Object> getDataNonExpired(String category) {
        return (List<Object>) gdao.execute(7, null, type, category, null);
    }
    
     public List<Object> getStatus2() throws SQLException {
        List<Object> list = new ArrayList<>();

        this.c = sf.getSessionFactoryOptions()
                .getServiceRegistry().getService(ConnectionProvider.class)
                .getConnection();
        CallableStatement cs = c.prepareCall("{call cv_online.getStatus2(?,?,?,?)}");
        cs.registerOutParameter(1, Types.INTEGER);
        cs.registerOutParameter(2, Types.VARCHAR);
        cs.registerOutParameter(3, Types.CHAR);
        cs.registerOutParameter(4, Types.INTEGER);
        cs.execute();
        list.add(cs.getInt(1));
        list.add(cs.getString(2));
        list.add(cs.getString(3));
        list.add(cs.getInt(4));
        //return cs.getString(1);
        return list;
    }

    public int addRegion1(String regionName) throws SQLException {
        Connection con = sf.getSessionFactoryOptions().getServiceRegistry().
                getService(ConnectionProvider.class).getConnection();

        CallableStatement callableStatement
                = con.prepareCall("{call hr.addRegions1(?,?)}");
        callableStatement.setString(1, regionName);
        callableStatement.registerOutParameter(2, Types.INTEGER);
        callableStatement.execute();

        return callableStatement.getInt(2);
    }

    public boolean addRegion2(String regionName) throws SQLException {
        boolean hasil = true;
        Connection con = sf.getSessionFactoryOptions().getServiceRegistry().
                getService(ConnectionProvider.class).getConnection();

        CallableStatement callableStatement = con.prepareCall("{call hr.addRegions(?)}");
        callableStatement.setString(1, regionName);
        hasil = callableStatement.execute();
        return hasil;
    }

    public int jmlRegions() throws SQLException {
        this.c = sf.getSessionFactoryOptions()
                .getServiceRegistry().getService(ConnectionProvider.class)
                .getConnection();
        CallableStatement cs = c.prepareCall("{call hr.updateUser(?,?,?,?)}");
        cs.execute();
        return cs.getInt(5);
    }
}
