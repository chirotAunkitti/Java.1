package com.aliboucoding.jpa;

import com.aliboucoding.jpa.mosels.Author;
import com.aliboucoding.jpa.mosels.Course;
import com.aliboucoding.jpa.repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class CourseTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    @Transactional
    public void testCreateCourse() {
        // Given
        Course course = Course.builder()
                .title("Java Programming")
                .description("Learn Java programming from basics to advanced topics")
                .authors(Arrays.asList(
                        Author.builder().firstName("John").lastName("Doe").age(30).build(),
                        Author.builder().firstName("Jane").lastName("Smith").age(35).build()
                ))
                .build();

        // When
        courseRepository.save(course);

        // Then
        assertNotNull(course.getId());
        Optional<Course> savedCourseOptional = courseRepository.findById(course.getId().longValue());
        Course savedCourse = savedCourseOptional.orElse(null);
        assertNotNull(savedCourse);
        assertEquals("Java Programming", savedCourse.getTitle());
    }

}