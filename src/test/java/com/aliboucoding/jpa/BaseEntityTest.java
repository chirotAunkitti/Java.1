package com.aliboucoding.jpa;

import com.aliboucoding.jpa.mosels.BaseEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class BaseEntityTest {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setUp() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testSetAndGetId() {
        Long id = 1L;
        baseEntity.setId(id);
        assertEquals(id, baseEntity.getId());
    }

    @Test
    public void testSetAndGetCreatedAt() {
        LocalDateTime now = LocalDateTime.now();
        baseEntity.setCreatedAt(now);
        assertEquals(now, baseEntity.getCreatedAt());
    }

    @Test
    public void testSetAndGetLastModifiedAt() {
        LocalDateTime now = LocalDateTime.now();
        baseEntity.setLastModifiedAt(now);
        assertEquals(now, baseEntity.getLastModifiedAt());
    }

    @Test
    public void testSetAndGetCreatedBy() {
        baseEntity.setCreatedBy("creator");
        assertEquals("creator", baseEntity.getCreatedBy());
    }

    @Test
    public void testSetAndGetLastModifiedBy() {
        baseEntity.setLastModifiedBy("modifier");
        assertEquals("modifier", baseEntity.getLastModifiedBy());
    }
}
