package com.hibernate.demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	
    public static void main( String[] args ) {

    	SessionFactory sf = null;
    	Session s = null;
    	Transaction tx = null;
    	
    	try {
    		sf = new Configuration().configure().buildSessionFactory();
    		s  = sf.openSession();
    		tx = s.beginTransaction();
    		
    	/*	Address address1 = new Address("abc street","Trichy",621008);
    		Address address2 = new Address("xyz street","Chennai",621008);
    		
    		Person person1 = new Person("Gouse",address1);
    		Person person2 = new Person("Santhosh",address2);
    		
    		s.save(person1);
    		s.save(person2); */
    		
    	/*	Person p1 = s.get(Person.class, 2l);
    		
    		System.out.println(p1.getName());
    		
    		Address a1 = s.get(Address.class, p1.getId());
    		
    		System.out.println(a1.getPinCode());
    		a1.setPinCode(600001);
    		
    		s.save(a1);
    		
    		System.out.println(p1.getName()+a1); */
    		
    		Person p1 = s.get(Person.class, 1l);
    		
    		s.delete(p1);
    		
    		
    	}
    	catch(HibernateException e) {
    		if(tx != null)
    			tx.rollback();
    		e.printStackTrace();
    	}
    	catch(Exception e) {
    		if(tx != null)
    			tx.rollback();
    		e.printStackTrace();
    	}
    	finally {
			if(tx != null)
				tx.commit();
			if(s != null)
				s.close();
			if(sf != null)
				sf.close();
		}
    }
}
