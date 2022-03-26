package Peaksoft;

import Peaksoft.Entity.Customer;
import Peaksoft.Service.Service;
import Peaksoft.Util.HibernateConf;

import java.util.Iterator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        HibernateConf.getSessionFactory();
        Customer customer = new Customer("Mirbek","Atabekov");
        Service service = new Service();
        service.addCustomer(customer);
        service.filterByName("Mirbek");
//        service.getCustomerById(4);
//
//        service.updateCustomerName(3,"Messi","Pessi");

//        Iterator<Customer> iterator = service.getAllCustomers().iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//    service.deleteALlData();
//        service.getAllCustomers();
    }
}
