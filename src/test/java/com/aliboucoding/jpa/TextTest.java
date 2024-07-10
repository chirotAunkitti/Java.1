package com.aliboucoding.jpa;

import com.aliboucoding.jpa.mosels.Text;
import com.aliboucoding.jpa.repositories.TextRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class TextTest {

    @Autowired
    private TextRepository textRepository;

    @Test
    @Transactional
    public void testCreateText() {
        // Given
        Text text = Text.builder()
                .type("Article")
                .content("This is a sample text content.")
                .build();

        // When
        textRepository.save(text);

        // Then
        assertNotNull(text.getId()); // Ensure text ID is not null
        Text savedText = textRepository.findById(text.getId()).orElse(null); // Ensure saved text is not null
        assertNotNull(savedText);
        assertEquals("Article", savedText.getType()); // Check text type
        assertEquals("This is a sample text content.", savedText.getContent()); // Check text content
    }
}
