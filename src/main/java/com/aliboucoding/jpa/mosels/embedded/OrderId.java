package com.aliboucoding.jpa.mosels.embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OrderId implements Serializable {

    private Long orderId;
    private String orderName;

    @Override
    public String toString() {
        return "OrderId(orderId=" + orderId +
                ", orderName=" + orderName +
                ")";
    }
}
