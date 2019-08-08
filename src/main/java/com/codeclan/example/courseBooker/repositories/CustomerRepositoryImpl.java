package com.codeclan.example.courseBooker.repositories;

import com.codeclan.example.courseBooker.models.Course;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Course> getCoursesFromCustomerId(Long id){
        List<Course> results = null;
        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Course.class);
            cr.createAlias("bookings", "bookingsAlias");
            cr.add(Restrictions.eq("bookingsAlias.customer.id", id));

            results = cr.list();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return results;
    }
}
