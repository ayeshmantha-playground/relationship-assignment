package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    private String id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @Setter(AccessLevel.NONE)
    private List<Contact> contact = new ArrayList<>();
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @Setter(AccessLevel.NONE)
    private List<Order> orders = new ArrayList<>();

//    public Customer(String id, String name, String address, List<Contact> contact) {
//        if(contact != null && !contact.isEmpty()){
//            contact.stream().filter(cnt -> cnt.getCustomer() == null ).forEach(cnt -> cnt.setCustomer(this));
//        }
//
//        if(contact != null && !contact.isEmpty()){
//            contact.forEach(cnt ->{
//                if(cnt.getCustomer() != this ){
//                    throw new IllegalStateException("Contact is already associated with another customer");
//                }
//            });
//        }
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        this.contact = contact;
//    }

    public Customer(String id, String name, String address, List<Contact> contact, List<Order> orders) {

        if(contact != null && !contact.isEmpty()){
            contact.stream().filter(cnt -> cnt.getCustomer() == null ).forEach(cnt -> cnt.setCustomer(this));
        }

        if(contact != null && !contact.isEmpty()){
            contact.forEach(cnt ->{
                if(cnt.getCustomer() != this ){
                    throw new IllegalStateException("Contact is already associated with another customer");
                }
            });
        }


        if(orders != null && !orders.isEmpty()){
            orders.stream().filter(order -> order.getCustomer() == null ).forEach(order -> order.setCustomer(this));
        }

        if(orders != null && !orders.isEmpty()){
            orders.forEach(order ->{
                if(order.getCustomer() != this ){
                    throw new IllegalStateException("Contact is already associated with another customer");
                }
            });
        }


        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.orders = orders;
    }

    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", address='" + address + '\'' +
               '}';
    }
}
