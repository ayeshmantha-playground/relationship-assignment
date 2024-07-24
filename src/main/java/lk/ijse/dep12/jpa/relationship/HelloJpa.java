package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

public class HelloJpa {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {

            System.out.println("EMF: " +emf);
            System.out.println("EM: " +em);

            try {


            } catch (Throwable throwable) {

            }

        }
    }
}
