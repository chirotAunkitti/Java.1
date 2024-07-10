package com.aliboucoding.jpa;

import com.aliboucoding.jpa.mosels.Video;
import com.aliboucoding.jpa.repositories.VideoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class VideoTest {

    @Autowired
    private VideoRepository videoRepository;

    @Test
    @Transactional
    public void testCreateVideo() {
        // Given
        Video video = Video.builder()
                .type("Tutorial")
                .length(120)
                .build();

        // When
        videoRepository.save(video);

        // Then
        assertNotNull(video.getId()); // Ensure video ID is not null
        Video savedVideo = videoRepository.findById(video.getId()).orElse(null); // Ensure saved video is not null
        assertNotNull(savedVideo);
        assertEquals("Tutorial", savedVideo.getType()); // Check video type
        assertEquals(120, savedVideo.getLength()); // Check video length
    }
}
