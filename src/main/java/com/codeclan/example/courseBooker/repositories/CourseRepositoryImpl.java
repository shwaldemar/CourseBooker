package com.codeclan.example.courseBooker.repositories;

import com.codeclan.example.courseBooker.models.Course;
import com.codeclan.example.courseBooker.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Customer> findCustomersByCourseId(Long id){

        List<Customer> result = null;

        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria criteria = session.createCriteria(Customer.class);
            criteria.createAlias("bookings","bookingAlias");
            criteria.add(Restrictions.eq("bookingAlias.course.id", id));
            result = criteria.list();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
        }

        return result;
    }

}

