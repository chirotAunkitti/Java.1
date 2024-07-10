package com.aliboucoding.jpa;

import com.aliboucoding.jpa.mosels.Resource;
import com.aliboucoding.jpa.mosels.Lecture;
import com.aliboucoding.jpa.repositories.ResourceRepository;
import com.aliboucoding.jpa.repositories.LectureRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ResourceTest {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private LectureRepository lectureRepository;

    @Test
    public void testCreateAndRetrieveResource() {
        // Given
        Lecture lecture = Lecture.builder()
                .name("Introduction to Java")
                .build();
        lecture = lectureRepository.save(lecture);

        Resource resource = Resource.builder()
                .name("Java Basics PDF")
                .size(1024)
                .url("https://example.com/java-basics.pdf")
                .type("PDF")
                .lecture(lecture)
                .build();

        // When
        Resource savedResource = resourceRepository.save(resource);

        // Then
        assertNotNull(savedResource.getId(), "Resource ID should not be null");

        Resource retrievedResource = resourceRepository.findById(savedResource.getId()).orElse(null);
        assertNotNull(retrievedResource, "Retrieved resource should not be null");

        assertEquals("Java Basics PDF", retrievedResource.getName(), "Resource name should match");
        assertEquals(1024, retrievedResource.getSize(), "Resource size should match");
        assertEquals("https://example.com/java-basics.pdf", retrievedResource.getUrl(), "Resource URL should match");
        assertEquals("PDF", retrievedResource.getType(), "Resource type should match");

        assertNotNull(retrievedResource.getLecture(), "Associated lecture should not be null");
        assertEquals(lecture.getId(), retrievedResource.getLecture().getId(), "Associated lecture ID should match");
    }

    @Test
    public void testUpdateResource() {
        // Given
        Resource resource = Resource.builder()
                .name("Old Resource")
                .size(100)
                .url("https://example.com/old")
                .type("TXT")
                .build();
        resource = resourceRepository.save(resource);

        // When
        resource.setName("Updated Resource");
        resource.setSize(200);
        resource.setUrl("https://example.com/updated");
        resource.setType("PDF");
        Resource updatedResource = resourceRepository.save(resource);

        // Then
        Resource retrievedResource = resourceRepository.findById(updatedResource.getId()).orElse(null);
        assertNotNull(retrievedResource, "Retrieved resource should not be null");
        assertEquals("Updated Resource", retrievedResource.getName(), "Resource name should be updated");
        assertEquals(200, retrievedResource.getSize(), "Resource size should be updated");
        assertEquals("https://example.com/updated", retrievedResource.getUrl(), "Resource URL should be updated");
        assertEquals("PDF", retrievedResource.getType(), "Resource type should be updated");
    }

    @Test
    public void testDeleteResource() {
        // Given
        Resource resource = Resource.builder()
                .name("Resource to Delete")
                .size(50)
                .url("https://example.com/delete-me")
                .type("DOC")
                .build();
        resource = resourceRepository.save(resource);

        // When
        resourceRepository.delete(resource);

        // Then
        assertFalse(resourceRepository.existsById(resource.getId()), "Resource should be deleted");
    }
}
