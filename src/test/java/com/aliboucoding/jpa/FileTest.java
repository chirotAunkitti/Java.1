package com.aliboucoding.jpa;


import com.aliboucoding.jpa.mosels.File;
import com.aliboucoding.jpa.repositories.FileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class FileTest {

    @Autowired
    private FileRepository fileRepository;

    @Test
    @Transactional
    public void testCreateFile() {
        // Given
        File file = File.builder()
                .type("PDF")
                .build();

        // When
        fileRepository.save(file);

        // Then
        assertNotNull(file.getId());
        File savedFile = fileRepository.findById(file.getId()).orElse(null); // แก้จาก file.getId() เป็น Long.valueOf(file.getId())
        assertNotNull(savedFile);
        assertEquals("PDF", savedFile.getType());
    }

}
