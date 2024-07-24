package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.relationship.entity.*;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Demo3 {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {

            try {
                em.getTransaction().begin();
                Customer customer = em.find(Customer.class, "C001");
                Item item = new Item("I001", "Rice", 2, new BigDecimal("250.00"));
                User user = new User("U001", "1234", "Nimal");

                Order od001 = new Order("OD001", Date.valueOf(LocalDate.now()), customer, user);

                OrderItems orderItems = new OrderItems(new BigDecimal("250.00"), 20, od001, item);

                List.of(item,user,orderItems).forEach(em::persist);

                em.getTransaction().commit();
            } catch (Throwable throwable) {
                em.getTransaction().rollback();
                throwable.printStackTrace();
            }

        }
    }
}
