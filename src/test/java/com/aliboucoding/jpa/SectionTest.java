package com.aliboucoding.jpa;

import com.aliboucoding.jpa.mosels.Course;
import com.aliboucoding.jpa.mosels.Section;
import com.aliboucoding.jpa.repositories.CourseRepository;
import com.aliboucoding.jpa.repositories.SectionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class SectionTest {

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    @Transactional
    public void testCreateSection() {
        // Given
        Course course = Course.builder()
                .name("Computer Science 101")
                .build();
        courseRepository.save(course);

        Section section = Section.builder()
                .name("Introduction")
                .sectionOrder(1)
                .course(course)
                .build();

        // When
        sectionRepository.save(section);

        // Then
        assertNotNull(section.getId()); // Ensure section ID is not null
        Section savedSection = sectionRepository.findById(section.getId()).orElse(null); // Ensure saved section is not null
        assertNotNull(savedSection);
        assertEquals("Introduction", savedSection.getName()); // Check section name
        assertEquals(1, savedSection.getSectionOrder()); // Check section order
        assertEquals(course.getId(), savedSection.getCourse().getId()); // Check course ID
    }
}
