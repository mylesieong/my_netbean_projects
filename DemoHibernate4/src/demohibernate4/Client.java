/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demohibernate4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Myles
 */
public class Client {
    private static SessionFactory factory;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Prepare a CigarNews instance for inserting operation*/
        CigarNews m=new CigarNews("New Model Released!");
        m.setId(1);
        m.setNews("New Model Release!!");
        System.out.println(m.getId());        
        System.out.println(m.getNews());
        System.out.println("Instance created and functioned well. Insert operation is soon kickoff...");
        
        /* Prepare the connection */
        factory = new Configuration().configure().buildSessionFactory();
                
        /* Perform the insert operation */
        Client.addCigarNews(m);

        /* Close up the connection*/
        factory.close();
        
    }

    private static void addCigarNews(CigarNews m) {
        /* initiate session from factory*/
        Session session=factory.openSession();
        Transaction transaction=null;
        transaction = session.beginTransaction();
        
        /*perform inserting*/
        session.save(m);
        transaction.commit();
        
        /*Close session*/
        session.close();
    }

    
}
