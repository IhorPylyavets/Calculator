package com.goit.project.database;

import com.goit.project.database.entity.Computing;
import com.goit.project.database.entity.User;
import com.goit.project.database.persistence.HibernateUtil;
import org.hibernate.Session;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EnterPoint {
    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        /*User user = new User();

        user.setUserLogin("Alexander1134");
        user.setUserPassword("Barchuk1132");*/
        Computing computing = new Computing();

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        computing.setTimeComputing(dateFormat.format(date));

        computing.setExpression("(56+44)/5");
        computing.setResult("20");
        computing.setUserId(1);

        session.save(computing);
        session.getTransaction().commit();
    }
}
