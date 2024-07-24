package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(OrderItemPK.class)
@Table(name = "order_item")
public class OrderItems implements Serializable {
    private BigDecimal price;
    private int discount;
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "item_code", referencedColumnName = "code")
    private Item item;
}
