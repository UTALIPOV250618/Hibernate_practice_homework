package Peaksoft.Service;

import Peaksoft.Entity.Customer;
import Peaksoft.Util.HibernateConf;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Service {

    public static void addCustomer(Customer customer){
        Session session = HibernateConf.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
        System.out.println("Customer added successfully "+ customer);
    }

    public static void getCustomerById(long customer_id){
        Session session = HibernateConf.getSessionFactory().openSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class,customer_id);
        session.getTransaction().commit();
        session.close();
        System.out.println("Requested Customer is "+ customer);
    }


    public static void updateCustomerName(long customerId, String customer_name,String customer_surname){
        Session session = HibernateConf.getSessionFactory().openSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class,customerId);
        customer.setCustomer_name(customer_name);
        customer.setCustomer_surname(customer_surname);
        session.getTransaction().commit();
        session.close();
        System.out.println("Customer info updated successfully "+ customer);
    }

    public static List<Customer> filterByName(String filterByName){
        Session session = HibernateConf.getSessionFactory().openSession();
        session.beginTransaction();
      Query query = session.createQuery("FROM Customer WHERE customer_name =?1");
      query.setParameter(1,filterByName);
      List<Customer> customerList =query.list();
        for (Customer s:customerList
             ) {
            System.out.println(s);
        }
        return customerList;

    }
    public static void deleteALlData(){
        Session session = HibernateConf.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Customer");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all data from Customers");

    }

    public static List<Customer> getAllCustomers(){

        Session session = HibernateConf.getSessionFactory().openSession();
        session.beginTransaction();
        List<Customer> customers = session.createQuery("FROM Customer").getResultList();
        session.getTransaction().commit();
        session.close();

        for (Customer c :customers
        ) {
            System.out.println(c);
        }

        return customers;

        }

    }


