package com.aliboucoding.jpa.embedded;

import com.aliboucoding.jpa.mosels.embedded.Address;
import com.aliboucoding.jpa.mosels.embedded.Order;
import com.aliboucoding.jpa.mosels.embedded.OrderId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderTest {

    @Test
    public void testOrderCreation() {
        // Given
        OrderId orderId = new OrderId(1L, "ABC");
        Address address = new Address("Main Street", "123", "12345");
        String orderInfo = "Sample order";
        String anotherField = "Additional info";

        // When
        Order order = new Order(orderId, address, orderInfo, anotherField);

        // Then
        assertNotNull(order, "Order object should not be null");
        assertEquals(orderId, order.getId(), "Order ID should match");
        assertEquals(address, order.getAddress(), "Address should match");
        assertEquals(orderInfo, order.getOrderInfo(), "Order info should match");
        assertEquals(anotherField, order.getAnotherField(), "Another field should match");
    }

    @Test
    public void testOrderToString() {
        // Given
        OrderId orderId = new OrderId(1L, "ABC");
        Address address = new Address("Main Street", "123", "12345");
        String orderInfo = "Sample order";
        String anotherField = "Additional info";

        // When
        Order order = new Order(orderId, address, orderInfo, anotherField);
        String orderString = order.toString();

        // Then
        String expectedString = "Order(id=OrderId(orderId=1, orderName=ABC), address=Address(streetName=Main Street, houseNumber=123, zipCode=12345), orderInfo=Sample order, anotherField=Additional info)";
        assertEquals(expectedString, orderString, "ToString method should produce correct format");
    }
}
