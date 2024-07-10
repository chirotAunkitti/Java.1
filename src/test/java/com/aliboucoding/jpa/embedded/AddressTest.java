package com.aliboucoding.jpa.embedded;

import com.aliboucoding.jpa.mosels.embedded.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {

    @Test
    public void testAddressCreation() {
        // Given
        String streetName = "Main Street";
        String houseNumber = "123";
        String zipCode = "12345";

        // When
        Address address = new Address(streetName, houseNumber, zipCode);

        // Then
        assertEquals(streetName, address.getStreetName(), "Street name should match");
        assertEquals(houseNumber, address.getHouseNumber(), "House number should match");
        assertEquals(zipCode, address.getZipCode(), "Zip code should match");
    }

    @Test
    public void testAddressEquality() {
        // Given
        Address address1 = new Address("Main Street", "123", "12345");
        Address address2 = new Address("Main Street", "123", "12345");

        // Then
        assertEquals(address1, address2, "Addresses should be equal");
    }

    @Test
    public void testAddressToString() {
        // Given
        Address address = new Address("Main Street", "123", "12345");

        // When
        String addressString = address.toString();

        // Then
        assertEquals("Address(streetName=Main Street, houseNumber=123, zipCode=12345)", addressString, "ToString method should produce correct format");
    }
}
