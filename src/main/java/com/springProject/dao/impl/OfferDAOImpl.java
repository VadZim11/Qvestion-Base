package com.springProject.dao.impl;

import com.springProject.dao.OfferDAO;
import com.springProject.entity.Offer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class OfferDAOImpl implements OfferDAO {
    @Autowired
    SessionFactory sessionFactory;

    private String resultQuery;

    public OfferDAOImpl() {
    }

    /*
    * Insert notification if state not 'end'
    */
    public String insertData(int id, String state) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Offer offer = new Offer();

            //Receive status with specify id - required for check field state = at status end or not.
            List result = session.createCriteria(Offer.class, "id")
                    .add(Restrictions.eq("payment_id", id))
                    .setProjection(Projections.property("title"))
                    .list();

            // Check first row - if no row exist, add status
            boolean isTrue;
            if (result.size() == 0) {
                isTrue = true;
            } else {
                isTrue = true;

                // If has row - cast to String with no [] and check status: if 'end' - no action.
                // If state "ref" can change status to ref from end.
                int countRef = 0;
                for (Object obj : result) {
                    String stringList = obj.toString();
                    if (stringList.equals("end")) {
                        isTrue = false;
                    }
                    if(stringList.equals("ref")){
                        countRef++;
                    }
                }

                //check for state - if have "end" state and previous state "ref" nok
                if(state.equals("end") && countRef > 0){
                    isTrue = false;
                }

            }

            // Receive current status - require adding or not.
            if (isTrue) {
                offer.setDescription("krokodil");
                offer.setPrice(BigDecimal.valueOf(20.00));
                offer.setTitle(state);
                offer.setPayment_id(201);
                session.save(offer);
            }

            session.getTransaction().commit();
            return "success";
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return "fail: " + e;
        }finally {
            session.close();
        }
    }

    public String getResult(int id, String state) {
        insertData(id, state);
        return resultQuery;
    }
}
