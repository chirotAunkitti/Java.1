package com.aliboucoding.jpa.mosels.embedded;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "orders") // เปลี่ยนจาก "_order" เป็น "orders" เพื่อหลีกเลี่ยงปัญหาการใช้ชื่อตารางที่อาจเป็นคำสงวน
public class Order {

    @EmbeddedId
    private OrderId id;

    @Embedded
    private Address address;

    private String orderInfo;

    private String anotherField;

    @Override
    public String toString() {
        return "Order(id=" + id +
                ", address=" + address +
                ", orderInfo=" + orderInfo +
                ", anotherField=" + anotherField +
                ")";
    }
}
