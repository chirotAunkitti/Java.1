package com.aliboucoding.jpa;

import com.aliboucoding.jpa.mosels.Lecture;
import com.aliboucoding.jpa.mosels.Resource;
import com.aliboucoding.jpa.mosels.Section;
import com.aliboucoding.jpa.repositories.LectureRepository;
import com.aliboucoding.jpa.repositories.SectionRepository;
import com.aliboucoding.jpa.repositories.ResourceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class LectureTest {

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Test
    @Transactional
    public void testCreateLecture() {
        // Given
        Section section = Section.builder()
                .name("Introduction")
                .build();
        sectionRepository.save(section);

        Resource resource = Resource.builder()
                .type("Video")
                .build();
        resourceRepository.save(resource);

        Lecture lecture = Lecture.builder()
                .name("Java Basics")
                .section(section)
                .resource(resource)
                .build();
        // When
        Lecture savedLecture = lectureRepository.save(lecture);

        // Then
        assertNotNull(savedLecture.getId(), "Lecture ID should not be null");
        assertTrue(savedLecture.getId() > 0L, "Lecture ID should be greater than 0");

        Lecture retrievedLecture = lectureRepository.findById(savedLecture.getId()).orElse(null);
        assertNotNull(retrievedLecture, "Retrieved lecture should not be null");
        assertEquals("Java Basics", retrievedLecture.getName(), "Lecture name should match");
        assertEquals(section.getId(), retrievedLecture.getSection().getId(), "Section ID should match");
        assertEquals(resource.getId(), retrievedLecture.getResource().getId(), "Resource ID should match");
    }
}
