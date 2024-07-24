package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.relationship.entity.Contact;
import lk.ijse.dep12.jpa.relationship.entity.Customer;
import lk.ijse.dep12.jpa.relationship.entity.Order;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {

            try {
                em.getTransaction().begin();

                Customer customer = em.find(Customer.class, "C001");
                List<Contact> contact = customer.getContact();
                contact.forEach(System.out::println);
                List<Order> orders = customer.getOrders();
                orders.forEach(System.out::println);


                em.getTransaction().commit();
            } catch (Throwable throwable) {
                em.getTransaction().rollback();
                throwable.printStackTrace();
            }

        }
    }
}
