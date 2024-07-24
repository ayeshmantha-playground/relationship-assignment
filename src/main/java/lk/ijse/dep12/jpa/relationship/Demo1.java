package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.relationship.entity.Contact;
import lk.ijse.dep12.jpa.relationship.entity.Customer;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {

            try {
                em.getTransaction().begin();
                Contact contact1 = new Contact("077-123432", null);
                Contact contact2 = new Contact("071-123432", null);
                Contact contact3 = new Contact("078-123432", null);
                List<Contact> contacts = List.of(contact1, contact2, contact3);
//                Customer customer = new Customer("C001", "Kamal", "Colombo", contacts);

//                em.persist(customer);
                em.getTransaction().commit();
            } catch (Throwable throwable) {
                em.getTransaction().rollback();
                throwable.printStackTrace();
            }

        }
    }
}
