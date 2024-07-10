package com.aliboucoding.jpa.embedded;

import com.aliboucoding.jpa.mosels.embedded.OrderId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderIdTest {

    @Test
    public void testOrderIdToString() {
        // Given
        OrderId orderId = new OrderId(1L, "ABC");

        // When
        String orderIdString = orderId.toString();

        // Then
        String expectedString = "OrderId(orderId=1, orderName=ABC)";
        assertEquals(expectedString, orderIdString, "ToString method should produce correct format");
    }
}
