/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lenovo
 */
public class FunctionDAO {

    private final SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public FunctionDAO(SessionFactory sessionFactory) {
        this.factory = sessionFactory;
    }

    /**
     *
     * @param CRUD - 0 for Save/Update, 1 for delete, 2 for getById, 3 for
     * search, 4 for getLastId, selain 0-4 for getAll
     * @param type get classnya
     * @param category get categorinya
     * @param key get objecnya
     * @return get hasinya
     */
    public Object execute(int CRUD, Object object,
            Class type, String category, Object key) {
        Object obj = null;
        try {
            this.session = factory.openSession();
            this.transaction = session.beginTransaction();
            obj = this.getAction(session, CRUD, object, type, category, key);
            this.transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return obj;
    }

    /**
     * dok getAction
     *
     * @param session get session
     * @param crud get integer
     * @param object get objecnya
     * @param type get type classnya
     * @param category get categori berupa string
     * @param key get keyy brupa object
     * @return
     */
    private Object getAction(Session session, int crud,
            Object object, Class type, String category, Object key) {
        switch (crud) {
            case 0:
                boolean flag = false;
                session.saveOrUpdate(object);
                flag = true;
                return flag;
            case 1:
                flag = false;
                session.delete(object);
                flag = true;
                return flag;
            case 2:
                return session.createCriteria(type)
                        .add(Restrictions.eq(category, key))
                        .uniqueResult();
            case 3:
                if (key.equals(key.toString())) {
                    return session.createCriteria(type)
                            .add(Restrictions.like(category, "%" + key + "%").ignoreCase())
                            .list();
                } else {
                    return session.createCriteria(type)
                            .add(Restrictions.eq(category, key))
                            .list();
                }

            case 4:
                return session.createQuery("FROM " + type
                        .getSimpleName() + " ORDER BY 1 DESC").list().get(0);
            case 5:
                return session.createCriteria(type)
                        .add(Restrictions.eq(category, key))
                        .uniqueResult();
            case 6:
                return session.createQuery("FROM " + type
                        .getSimpleName() + " ORDER BY 1").list();
            default:
                return session.createQuery("FROM " + type
                        .getSimpleName() + " WHERE SYSDATE < " + category + " ORDER BY 1").list();
        }
    }
}
